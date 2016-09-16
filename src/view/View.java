package view;

import java.io.File;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;

public interface View {
	public void printOutput(String str);
	void notifyMazeIsReady(String name);
	void displayMaze(Maze3d maze);
	void start();
	public void displayFiles(File[] listOfFiles);
	public void displaySolution(Solution<Position> solution);
	public void displayCrossSection(int[][] maze2d);
}
