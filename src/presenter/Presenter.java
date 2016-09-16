package presenter;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.View;

public class Presenter implements Observer {
	
	private Model model;
	private View view;
	private CommandsManager commandsManager;
	private HashMap<String, Command> commands;
	
	public Presenter(Model model, View view) {
		this.model = model;
		this.view = view;
			
		commandsManager = new CommandsManager(this.model, this.view);
		commands = commandsManager.getCommandsMap();
	}

	/**
	 * update gets the input from the user and start the command
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o==view){
			String commandLine = (String)arg;
		
			String arr[] = commandLine.split(" ");
			String command = arr[0];			
			
			if(!commands.containsKey(command)) {
				view.printOutput("Command doesn't exist");			
			}
			else {
				String[] args = null;
				if (arr.length > 1) {
					String commandArgs = commandLine.substring(commandLine.indexOf(" ") + 1);
					args = commandArgs.split(" ");							
				}
				try {
					commands.get(command).doCommand(args);
				}
				catch (Exception e){
					view.printOutput("ERROR:");
					e.printStackTrace();
				}
			}
		}
		else {
			String message = (String)arg;
			view.printOutput(message);
		}
	}
}
