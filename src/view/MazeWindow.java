package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;

public class MazeWindow extends BasicWindow{
	protected Button generateMazeButton,generateSolutionButton,generateHintButton,generateResetButton;
	protected MazeDisplay maze;

	public MazeWindow(int width, int height) {
		super(width, height);	
	}

	@Override
	public void initWidgets() {
		GridLayout gridLayout = new GridLayout(2,false);
		shell.setLayout(gridLayout);
		shell.setText("Maze3D Project");
		
		generateMazeButton=(new Button(shell, SWT.PUSH));
		generateMazeButton.setText("genenrate maze");
		generateMazeButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
	
		//to check- OK!
		generateMazeButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				GenerateMazeWindow win = new GenerateMazeWindow(300,200);				
				win.run();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		maze=new MazeDisplay(shell,SWT.BORDER);
		maze.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4));
		
		generateSolutionButton=(new Button(shell, SWT.PUSH));
		generateSolutionButton.setText("solution");
		generateSolutionButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
		
		generateHintButton=(new Button(shell, SWT.PUSH));
		generateHintButton.setText("hint");
		generateHintButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
		
		generateResetButton=(new Button(shell, SWT.PUSH));
		generateResetButton.setText("reset");
		generateResetButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
	}
	
	public void generateMazeSelectionListener(SelectionListener listener){
		generateMazeButton.addSelectionListener(listener);
	}

}
