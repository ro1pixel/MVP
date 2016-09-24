package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

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
		generateMazeButton.setText("Genenrate Maze");
		generateMazeButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
	
		//to check- OK!
/*		generateMazeButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				GenerateMazeWindow win = new GenerateMazeWindow(300,210);				
				win.run();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
*/		
		maze=new MazeDisplay(shell,SWT.BORDER);
		maze.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4));
		
		generateSolutionButton=(new Button(shell, SWT.PUSH));
		generateSolutionButton.setText("Solution");
		generateSolutionButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
		
		generateHintButton=(new Button(shell, SWT.PUSH));
		generateHintButton.setText("Hint");
		generateHintButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
		
		generateResetButton=(new Button(shell, SWT.PUSH));
		generateResetButton.setText("Reset");
		generateResetButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
	}
	
	public void generateMazeSelectionListener(SelectionListener listener){
		generateMazeButton.addSelectionListener(listener);
	}

		private void initMenu() {
		Menu menu=new Menu(shell, SWT.BAR);
		MenuItem fileMenuItem=new MenuItem(menu,SWT.CASCADE);
		
		fileMenuItem.setText("Action");
		
		}

}
