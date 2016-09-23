package model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import controller.Controller;

public abstract class CommonModel extends Observable implements Model {
	protected ExecutorService executor;
	protected Map<String, Maze3d> mazes;
	protected Map<String, Solution<Position>> solutions;
	protected String generateType;
	protected String solveAlg;
	
	public CommonModel() {
		this.mazes = new ConcurrentHashMap<String, Maze3d>();
		this.solutions = new HashMap<>();
	}

	@Override
	public abstract void generateMaze(String name, int floors,int rows, int cols) ;

	@Override
	public abstract Maze3d getMaze(String name);
	@Override
	public abstract void saveMaze(String mazeName, String fileName) ;

	@Override
	public abstract void loadMaze(String mazeName, String fileName);

	@Override
	public abstract void exit() ;

	@Override
	public abstract File[] listFiles(String path);

	@Override
	public abstract void solveMaze(String mazeName,String alg) ;

	@Override
	public abstract Solution<Position> getSolution(String mazeName) ;

	@Override
	public abstract int[][] getCrossSection(String axis,Integer floor,String mazeName);
}