package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public abstract class BasicWindow implements Runnable{

	protected Display display;
	protected Shell shell;
	
	public BasicWindow(int width, int height) {
		display=new Display();
		shell=new Shell();
		
		shell.setSize(width, height);	
	}
	
	public abstract void initWidgets();
	
	@Override
	public void run() {
		initWidgets();
		shell.open();
		
		while(!shell.isDisposed()){ // window isn't closed
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		display.dispose();
	}

}
