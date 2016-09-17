package presenter;

import java.io.Serializable;

/**
 * Properties class to use implements Serializable
 */
public class Properties implements Serializable{

	private static final long serialVersionUID = 1L;
	private String generateMaze;
	private String solutionAlg;
	private int numThreads;

	/**
	 * CTOR
	 */
	public Properties() {
		this.generateMaze=null;
		this.solutionAlg=null;
	}
	
	/**
	 * CTOR
	 * @param generateMaze the Algorithm we will use to generate maze
	 * @param solutionAlg the Algorithm we will use to solve a maze
	 * @param numThreads the number we will put in the threadPool
	 */
	public Properties(String generateMaze, String solutionAlg, int numThreads){
		this.generateMaze=generateMaze;
		this.solutionAlg=solutionAlg;
		this.numThreads=numThreads;
	}
	
	/**
	 * copy CTOR
	 * @param pr- properties to copy
	 */
	public Properties(Properties pr) {
		this.generateMaze=pr.generateMaze;
		this.solutionAlg=pr.solutionAlg;
		this.numThreads=pr.numThreads;
	}
	
	/**
	 * get the generateMaze
	 * @return
	 */
	public String getGenerateMaze() {
		return generateMaze;
	}

	/**
	 * setter the generateMaze
	 * @param generateMaze
	 */
	public void setGenerateMaze(String generateMaze) {
		this.generateMaze = generateMaze;
	}

	/**
	 * get the solutionAlg
	 * @return
	 */
	public String getSolutionAlg() {
		return solutionAlg;
	}

	/**
	 * setter the solutionAlg
	 * @param solutionAlg
	 */
	public void setSolutionAlg(String solutionAlg) {
		this.solutionAlg = solutionAlg;
	}

	/**
	 * get the number of thread
	 * @return number of thread
	 */
	public int getNumThreads() {
		return numThreads;
	}

	/**
	 * setter the number of thread
	 * @param numThreads
	 */
	public void setNumThreads(int numThreads) {
		this.numThreads = numThreads;
	}

	
	
}
