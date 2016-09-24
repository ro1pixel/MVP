package model;

import java.io.File;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;

/**
 * Model interface
 */
public interface Model {
	public void generateMaze(String name, int floors,int rows, int cols);
	public Maze3d getMaze(String name);
	public File[] listFiles(String path);
	public void saveMaze(String mazeName, String fileName);
	public void loadMaze(String mazeName, String fileName);
	public void solveMaze(String mazeName,String alg);
	public Solution<Position> getSolution(String mazeName);
	public int[][] getCrossSection(String axis,Integer floor,String mazeName);
	public void saveCache();
	public void loadSolutions();
	public void loadProperties();
	public void saveProperties(String generateMaze, String solutionAlg, Integer numThreads, String viewStyle);
	public void editProperties(String generateMaze, String solutionAlg, Integer numThreads, String viewStyle);
	public void exit();
}
