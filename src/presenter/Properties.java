package presenter;

import java.io.Serializable;

/**
 * Properties class to use implements Serializable
 */
public class Properties implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String generateMaze;
	private String solutionAlg;

	/**
	 * CTOR
	 */
	public Properties() {
		this.generateMaze=null;
		this.solutionAlg=null;
	}
	
	/**
	 * copy CTOR
	 * @param pr- properties to copy
	 */
	public Properties(Properties pr) {
		this.generateMaze=pr.generateMaze;
		this.solutionAlg=pr.solutionAlg;
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

	
}
