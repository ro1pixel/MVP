package view;

import java.io.File;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import controller.Command;
import presenter.Presenter;

public interface View {
	public void printOutput(String str);
	void notifyMazeIsReady(String name);
	void displayMaze(Maze3d maze);
	void start();
	public void displayFiles(File[] listOfFiles);
	public void displaySolution(Solution<Position> solution);
	public void displayCrossSection(int[][] maze2d);
	void setPresenter(Presenter presenter);
	Presenter getPresenter();
	void setCommands(HashMap<String, Command> commands);
	
}
