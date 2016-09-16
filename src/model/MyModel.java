package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;

import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.BFS;
import algorithms.search.DFS;
import algorithms.search.Maze3dSearchable;
import algorithms.search.Solution;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

/**
 * MyModel class extends Observable implements Model
 */
public class MyModel extends Observable implements Model {
	
	//private ExecutorService executor;
	private Map<String, Maze3d> mazes;
	private HashMap<String, Solution<Position>> solutions;
	private List<Thread> threads;
	
	/**
	 * CTOR
	 */
	public MyModel() {
		//executor = Executors.newFixedThreadPool(50);
		mazes = new ConcurrentHashMap<String, Maze3d>();
		this.solutions = new HashMap<>();
		this.threads=new ArrayList<Thread>();
	}		
	
	/**
	 * generate the maze
	 * @param name
	 * @param floors
	 * @param rows
	 * @param cols
	 */
	@Override
	public void generateMaze(String name,int floors, int rows, int cols) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				GrowingTreeGenerator generator = new GrowingTreeGenerator();
				Maze3d maze = generator.generate(floors,rows, cols);
				mazes.put(name, maze);
				
				setChanged();
				notifyObservers("maze ready " + name);
			}
		});
		thread.start();
		threads.add(thread);
	}

	/**
	 * getter of maze
	 */
	@Override
	public Maze3d getMaze(String name) {
		return mazes.get(name);
	}

	/**
	 * return the list of the files
	 */
	@Override
	public File[] listFiles(String path) {
		if (path!=null){
			File f = new File(path);
			if (f.exists() && f.isDirectory()) {
				return new File(path).listFiles();
			}
			else{
				setChanged();
				notifyObservers("ERROR: directory :" + path +" dosent exist");
				return null;
			}
		}
		else{			
			setChanged();
			notifyObservers("ERROR: the path is empty");
			return null;
		}
	}
	
	/**
	 * save the maze into a file 
	 */
	@Override
	public void saveMaze(String mazeName,String fileName) {
		if (mazeName!=null && fileName!=null){
			if(mazes.containsKey(mazeName))
			{
				try {
				OutputStream out = new MyCompressorOutputStream(new FileOutputStream(fileName+".maz"));
				byte[] arr=mazes.get(mazeName).toByteArray();
				int counter=arr.length;
				while(counter>=255)
				{
					out.write(255);
					counter-=255;
				}
				out.write(counter);
				out.write(arr);			
				out.flush();
				out.close();
				setChanged();
				notifyObservers("the Maze was saved");
				}
				catch (Exception e) {
					setChanged();
					notifyObservers("Error on saving the maze");
				}
			}
			else{
				setChanged();
				notifyObservers("Error: maze doesn't exist");
			}
		}
		else{
			setChanged();
			notifyObservers("Error: the maze name or file name is empty");
		}
	}
	
	/**
	 * load the maze from a file
	 */
	@Override
	public void loadMaze(String mazeName,String fileName) {
		if (mazeName!=null && fileName!=null){
			if(!mazes.containsKey(mazeName))
			{
				try {
					InputStream in=new MyDecompressorInputStream(new FileInputStream(fileName+".maz"));
					int size=in.read();
					int sum=0;
					while(size==255)
					{	sum+=size;
						size=in.read();
					}
					sum+=size;
					byte b[]=new byte[sum];
					try{
						in.read(b);
						Maze3d loaded=new Maze3d(b);
						mazes.put(mazeName, loaded);
					}
					catch (IOException e) {
						e.printStackTrace();
					}
					finally {
						try {
							in.close();
						} 
						catch (IOException e) {
							setChanged();
							notifyObservers("Error to close file");
						}
					}
					setChanged();
					notifyObservers("Maze was loaded succesfully");
				}
				catch (Exception e) {
					setChanged();
					notifyObservers("Error in loading file");
				}
			}
			else 
				setChanged();
			notifyObservers("ERROR: maze name is incorrect ");
		}
		else {
			setChanged();
			notifyObservers("Error: the maze name or file name is empty");
		}
	}
	
	/**
	 * solve the maze
	 */
	@Override
	public void solveMaze(String mazeName,String alg){		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				if (mazeName!=null && alg!=null){
					if (mazes.containsKey(mazeName)){
						Maze3d maze=getMaze(mazeName);
						Solution<Position> solution = new Solution<>();
						Maze3dSearchable mazeAdapter = new Maze3dSearchable(maze);
					
						if(alg.toUpperCase().equals("BFS")) {
							BFS<Position> searcher = new BFS<>();
							solution = searcher.search(mazeAdapter);
							solutions.put(mazeName, solution);
							setChanged();
							notifyObservers("the solution is ready");
						}
						else if (alg.toUpperCase().equals("DFS")) {
							DFS<Position> searcher = new DFS<>();
							solution = searcher.search(mazeAdapter);
							solutions.put(mazeName, solution);
							setChanged();
							notifyObservers("the solution is ready");
						}
						else{
							setChanged();
							notifyObservers("ERROR: you entered the wrong solution name");
						}
					}
					else{
						setChanged();
						notifyObservers("ERROR: maze doesn't exist");
					}
				}
				else{
					setChanged();
					notifyObservers("Error: the maze name or algorithm is empty");
				}
			}
		});
		thread.start();
		threads.add(thread);
	}
	
	/**
	 * get the solution of the maze
	 */
	public Solution<Position> getSolution(String mazeName){
		if ( mazeName!=null )
		{
			if (mazes.containsKey(mazeName)){
					Solution<Position> sol= solutions.get(mazeName);
					if(sol!=null)
						return sol;
					else{
						setChanged();
						notifyObservers("ERROR: there is no solution yet");
						return null;
					}
				}
			else{
				setChanged();
				notifyObservers("ERROR: the maze doesn't exits");
				return null;
			}
		}
		else{
			setChanged();
			notifyObservers("Error: the maze name is empty");
			return null;
		}
	}
	
	/**
	 * get Cross Section
	 * axle index maze name
	 */
	public int[][] getCrossSection(String axis,Integer floors,String mazeName){
		if (axis!=null && floors!=null && mazeName!=null){
			Maze3d maze=this.mazes.get(mazeName);
			if (maze!=null)
				if(axis.toUpperCase().equals("X"))
					return maze.getCrossSectionByX(floors);
				else if(axis.toUpperCase().equals("Y"))
					return maze.getCrossSectionByY(floors);
				else if(axis.toUpperCase().equals("Z"))
					return maze.getCrossSectionByZ(floors);
				else{
					setChanged();
					notifyObservers("ERROR: the axle dosen't exist");
					return null;
				}
			else{
				setChanged();
				notifyObservers("ERROR: the maze is not exist");
				return null;
			}
		}
		else{
			setChanged();
			notifyObservers("ERROR: the axis of the floor or the maze name is empty");
			return null;
		}
		
	}
	
	/**
	 * exit command
	 */
	public void exit() {
		for (Thread t: threads){
			t.interrupt();
		}
		setChanged();
		notifyObservers("BYE BYE");
	}
	
}
