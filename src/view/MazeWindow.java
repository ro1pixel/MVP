package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class MazeWindow extends BasicWindow{
	protected Button generateMazeButton;
	protected Button solutionButton;
	protected Button hintButton,resetButton;
	protected MazeDisplay maze;
	protected Menu menuBar, FileMenu, HelpMenu;
    protected MenuItem cascadeFileMenu;
    protected MenuItem cascadeHelpMenu;
    protected MenuItem actionMenuItem;
    protected MenuItem newGameMenuItem;
    protected MenuItem loadMazeMenuItem;
    protected MenuItem saveMazeMenuItem;
    protected MenuItem editPropertiesMenuItem;
    protected MenuItem importPropertiesMenuItem;
    protected MenuItem exportPropertiesMenuItem;
    protected MenuItem exitMenuItem,aboutMenuItem;

	public MazeWindow(int width, int height) {
		super(width, height);	
	}

	@Override
	public void initWidgets() {
		initMenu();
		
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
		
		solutionButton=(new Button(shell, SWT.PUSH));
		solutionButton.setText("Solution");
		solutionButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
		
		hintButton=(new Button(shell, SWT.PUSH));
		hintButton.setText("Hint");
		hintButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
		
		resetButton=(new Button(shell, SWT.PUSH));
		resetButton.setText("Reset");
		resetButton.setLayoutData(new GridData(SWT.FILL,SWT.NONE,false,false,1,1));
	}
	
    private void initMenu() {
    	menuBar=new Menu(shell, SWT.BAR);	
    	cascadeFileMenu=new MenuItem(menuBar, SWT.CASCADE);
    	cascadeFileMenu.setText("File");

    	FileMenu=new Menu(shell,SWT.DROP_DOWN);
    	cascadeFileMenu.setMenu(FileMenu);

    	newGameMenuItem=new MenuItem(FileMenu, SWT.PUSH);
    	newGameMenuItem.setText("New Game");

    	loadMazeMenuItem=new MenuItem(FileMenu, SWT.PUSH);
    	loadMazeMenuItem.setText("Load Maze");

    	saveMazeMenuItem=new MenuItem(FileMenu, SWT.PUSH);
    	saveMazeMenuItem.setText("Save Maze");

    	editPropertiesMenuItem=new MenuItem(FileMenu, SWT.PUSH);
    	editPropertiesMenuItem.setText("edit properties");

    	importPropertiesMenuItem=new MenuItem(FileMenu, SWT.PUSH);
    	importPropertiesMenuItem.setText("Import properties");

    	exportPropertiesMenuItem=new MenuItem(FileMenu, SWT.PUSH);
    	exportPropertiesMenuItem.setText("Export properties");

    	exitMenuItem=new MenuItem(FileMenu, SWT.PUSH);
    	exitMenuItem.setText("EXIT");
    	
    	cascadeHelpMenu =new MenuItem(menuBar, SWT.CASCADE);
    	cascadeHelpMenu.setText("Help");

    	HelpMenu=new Menu(shell,SWT.DROP_DOWN);
    	cascadeHelpMenu.setMenu(HelpMenu);

    	aboutMenuItem=new MenuItem(HelpMenu, SWT.PUSH);
    	aboutMenuItem.setText("about");

    	shell.setMenuBar(menuBar);
    }
    
    public void generateMazeSelectionListener(SelectionListener listener){
		generateMazeButton.addSelectionListener(listener);
		newGameMenuItem.addSelectionListener(listener);
	}
	
	public void solutionSelectionListener(SelectionListener listener){
		solutionButton.addSelectionListener(listener);
	}
	
	public void hintSelectionListener(SelectionListener listener){
		hintButton.addSelectionListener(listener);
	}
	
	public void resetSelectionListener(SelectionListener listener){
		resetButton.addSelectionListener(listener);
	}
	
	public void loadMazeSelectionListener(SelectionListener listener){
		loadMazeMenuItem.addSelectionListener(listener);
	}
	
	public void saveMazeSelectionListener(SelectionListener listener){
		saveMazeMenuItem.addSelectionListener(listener);
	}
	
	public void editPropertiesSelectionListener(SelectionListener listener){
		editPropertiesMenuItem.addSelectionListener(listener);
	}

	public void importPropertiesSelectionListener(SelectionListener listener){
		importPropertiesMenuItem.addSelectionListener(listener);
	}
	
	public void exportPropertiesSelectionListener(SelectionListener listener){
		exportPropertiesMenuItem.addSelectionListener(listener);
	}
	public void exitSelectionListener(SelectionListener listener){
		exitMenuItem.addSelectionListener(listener);
	};

}
