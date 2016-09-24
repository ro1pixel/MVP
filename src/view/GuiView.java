package view;

import java.io.File;
import java.util.Observable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;

public class GuiView extends CommonView{
	protected Maze3d maze;
	protected String mazeName;
	protected MazeWindow mazeWindow;
	
	public GuiView() {
		mazeWindow=new MazeWindow(100, 100);
		
		mazeWindow.generateMazeSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				GenerateMazeWindow win = new GenerateMazeWindow(300,210);			
				win.run();
				mazeName=win.getName();
				setChanged();
				notifyObservers("generate_maze "+mazeName+ " "+ win.getFloors()+ " " + win.getCols()+ " "+ win.getRows());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		mazeWindow.solutionSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("solve "+ mazeName +" ");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		mazeWindow.hintSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		mazeWindow.resetSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Position start= maze.getStartPosition();
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		mazeWindow.loadMazeSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String fileName = mazeWindow.displayFileDialog(SWT.OPEN, "Load Maze", new String[] { "*.maz" },"C:\\");
				if(fileName != null) {
					setChanged();
					notifyObservers("load_maze "+mazeName+ " "+fileName);
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		mazeWindow.saveMazeSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String fileName = mazeWindow.displayFileDialog(SWT.SAVE, "Save maze", new String[] { "*.maz" }, "C:\\");
				if(fileName != null) {
					setChanged();
					notifyObservers("save_maze "+mazeName+" "+fileName);
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		mazeWindow.editPropertiesSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		mazeWindow.importPropertiesSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		mazeWindow.exportPropertiesSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		mazeWindow.exitSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				boolean response= mazeWindow.displayQuesion("Exit", "Are you sure you want to exit?");
				if (response){
					setChanged();
					notifyObservers("exit");
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
	}
	
	@Override
	public void printOutput(String str) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyMazeIsReady(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayMaze(Maze3d maze) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		mazeWindow.run();
	}

	@Override
	public void displayFiles(File[] listOfFiles) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displaySolution(Solution<Position> solution) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayCrossSection(int[][] maze2d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o == mazeWindow) {
			setChanged();
			notifyObservers(arg);
		}
		
	}
}
