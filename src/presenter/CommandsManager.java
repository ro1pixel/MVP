package presenter;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import controller.Command;
import controller.CommandsManager.displayCrossSectionCommand;
import controller.CommandsManager.displayFilesInPathCommand;
import controller.CommandsManager.displaySolutionCommand;
import controller.CommandsManager.exitCommand;
import controller.CommandsManager.loadMazeCommand;
import controller.CommandsManager.saveMazeCommand;
import controller.CommandsManager.solveMazeCommand;
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
			view.displayFiles(model.listFiles(args));
		}
	}

	/**
	 * save the maze into a file
	 *
	 */
	public class saveMazeCommand implements Command {

		@Override
		public void doCommand(String[] args) {
				model.saveMaze(args);
		}
	}
	/**
	 * load a maze from file
	 *
	 */
	public class loadMazeCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			model.loadMaze(args);
		}
		
	}
	
	/**
	 * display Cross Section of the maze
	 *
	 */
	public class displayCrossSectionCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			view.displayCrossSection(model.getCrossSection(args));
		}
	}
	
	/**
	 * solve the Maze
	 *
	 */
	public class solveMazeCommand implements Command {

		@Override
		public void doCommand(String[] args) {
			model.solveMaze(args);
		}
	}
	
	/**
	 * display the solution of the maze
	 */
	public class displaySolutionCommand implements Command {

		@Override
		public void doCommand(String[] args) {
				view.displaySolution(model.getSolution(args));
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
