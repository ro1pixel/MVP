package model;

import java.util.Map;
import java.util.Observable;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;

/**
 * MyModel class extends Observable implements Model
 */
public class MyModel extends Observable implements Model {
	
	private ExecutorService executor;
	private Map<String, Maze3d> mazes;
	
	/**
	 * CTOR
	 */
	public MyModel() {
		executor = Executors.newFixedThreadPool(50);
		mazes = new ConcurrentHashMap<String, Maze3d>();
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
		executor.submit(new Callable<Maze3d>() {

			@Override
			public Maze3d call() throws Exception {
				GrowingTreeGenerator generator = new GrowingTreeGenerator();
				Maze3d maze = generator.generate(floors,rows, cols);
				mazes.put(name, maze);
				
				setChanged();
				notifyObservers("maze_ready " + name);		
				return maze;
			}
		});
	}

	/**
	 * getter of maze
	 */
	@Override
	public Maze3d getMaze(String name) {
		return mazes.get(name);
	}
	
	/**
	 * exit command
	 */
	public void exit() {
		executor.shutdownNow();
	}
}
