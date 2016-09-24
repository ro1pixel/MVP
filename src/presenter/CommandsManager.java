package presenter;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import model.Model;
import view.View;

/**
 * CommandsManager class
 */
public class CommandsManager {
	
	private Model model;
	private View view;
		
	/**
	 * CTOR
	 * @param model
	 * @param view
	 */
	public CommandsManager(Model model, View view) {
		this.model = model;
		this.view = view;		
	}
	
	/**
	 * Creates a hash map of all the commands
	 * @return commands
	 */
	public HashMap<String, Command> getCommandsMap() {
		HashMap<String, Command> commands = new HashMap<String, Command>();
		
		commands.put("dir", new displayFilesInPathCommand());
		commands.put("generate_maze", new GenerateMazeCommand());
		commands.put("display", new DisplayMazeCommand());
		commands.put("display_cross_section", new displayCrossSectionCommand());
		commands.put("save_maze", new saveMazeCommand());
		commands.put("load_maze", new loadMazeCommand());
		commands.put("solve", new solveMazeCommand());
		commands.put("display_solution", new displaySolutionCommand());
		commands.put("load_properties", new loadPropertiesCommand());
		commands.put("save_properties", new savePropertiesCommand());
		commands.put("edit_properties", new editPropertiesCommand());
		commands.put("exit", new exitCommand());
		//commands.put("maze_ready", new MazeReadyCommand());
		
		return commands;
	}
	
	/**
	 * Creates maze 
	 */
	class GenerateMazeCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			String name = args[0];
			int floors = Integer.parseInt(args[1]);
			int rows = Integer.parseInt(args[2]);
			int cols = Integer.parseInt(args[3]);
			model.generateMaze(name,floors, rows, cols);
		}		
	}
	
	/**
	 * Displays the maze 
	 */
	class DisplayMazeCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			String name = args[0];
			Maze3d maze = model.getMaze(name);
			view.displayMaze(maze);
		}		
	}
	
	/*class MazeReadyCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			String name = args[0];
			String msg = "maze " + name + " is ready";
		view.printOutput(msg);
		}
	}*/
	
	/**
	 * Displays the files in a specific folder
	 */
	public class displayFilesInPathCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			String path=args[0];
			view.displayFiles(model.listFiles(path));
		}
	}

	/**
	 * save the maze into a file
	 *
	 */
	public class saveMazeCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			String mazeName=args[0];
			String fileName=args[1];
			model.saveMaze(mazeName,fileName);
		}
	}
	/**
	 * load a maze from file
	 *
	 */
	public class loadMazeCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			String mazeName=args[0];
			String fileName=args[1];
			model.loadMaze(mazeName, fileName);
		}
	}
	
	/**
	 * display Cross Section of the maze
	 *
	 */
	public class displayCrossSectionCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			String axis=args[0];
			Integer floors= Integer.parseInt(args[1]);
			String mazeName = args[2];
			view.displayCrossSection(model.getCrossSection(axis,floors,mazeName));
		}
	}
	
	/**
	 * solve the Maze
	 *
	 */
	public class solveMazeCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			String mazeName=args[0];
			String alg=args[1];
			model.solveMaze(mazeName ,alg);
		}
	}
	
	/**
	 * display the solution of the maze
	 */
	public class displaySolutionCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			String mazeName=args[0];
			view.displaySolution(model.getSolution(mazeName));
		}
	}
	
	public class loadPropertiesCommand implements Command{
		
		@Override
		public void doCommand(String[] args) {
			model.loadProperties(args[0]);
		}
	}
	
	public class savePropertiesCommand implements Command{
		
		@Override
		public void doCommand(String[] args) {
			model.saveProperties(args[0]);
		}
	}
	
public class editPropertiesCommand implements Command{
		
		@Override
		public void doCommand(String[] args) {
			String generateMaze=args[0];
			String solutionAlg=args[1];
			Integer numThreads=Integer.parseInt(args[2]);
			String viewStyle=args[3];
			model.editProperties(generateMaze, solutionAlg, numThreads, viewStyle);
		}
	}
	
	/**
	 * exit
	 */
	public class exitCommand implements Command {
		@Override
		public void doCommand(String[] args) {
			model.exit();
		}
	}
	
}
