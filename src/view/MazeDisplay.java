package view;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;

public class MazeDisplay extends Canvas{
	protected Maze3d maze;
	protected Position characterPosition;
	protected boolean solved;


	/**
	 * Instantiate the maze display with the given parent &amp; style
	 * @param parent Parent of the widget
	 * @param style Style for the widget
	 */
	public MazeDisplay(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * Set the maze displayed by this widget
	 * @param maze The maze to display
	 */
	public void setMaze(Maze3d maze) {
		this.maze = maze;
	}

	/**
	 * Set the character position
	 * @param position Character position
	 */
	public void setCharacterPosition(Position position) {
		characterPosition = position;
		redraw();
	}

	/**
	 * Display that the maze was solved successfully
	 * @param solved Whether or not the maze was solved
	 */
	public void setSolved(boolean solved) {
		this.solved = solved;
		redraw();
	}
	
	
}
