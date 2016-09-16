package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;

/**
 * * CLI Class
 */
public class CLI extends Observable {
	private BufferedReader in;
	private PrintWriter out;	
	
	/**
	 * CTOR
	 * @param in
	 * @param out
	 */
	public CLI(BufferedReader in, PrintWriter out) {
		this.in = in;
		this.out = out;		
	}
	
	public void start() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
				
					printMenu();
					try {
						String commandLine = in.readLine();
						setChanged();
						notifyObservers(commandLine);
						
						if (commandLine.equals("exit"))
							break;
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}			
		}).start();		
	}
	
	  /**
     * print using the out object
     * @param str the string we want to print
     */
    public void printOutput(String str) {
    	out.println(str);
        out.flush();
    }
    
    /**
     * Print a menu to the viewer
     */
	public void printMenu(){
    	printOutput("\n\n********************************");
    	printOutput("what do want to do? ");
		/*for (String command : commands.keySet()) {
			out.print(command + ",");
		}
		out.println(")");*/
		out.flush();
	}
}
