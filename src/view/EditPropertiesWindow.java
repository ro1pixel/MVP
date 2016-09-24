package view;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class EditPropertiesWindow extends BasicWindow {
	String generateMaze, solutionAlg, viewStyle;
	Integer numThreads;
	
	public EditPropertiesWindow(int width, int height) {
		super(width, height);
	}

	@Override
	public void initWidgets() {
		shell.setText("Edit Properties");
				
		shell.setLayout(new GridLayout(2, false));	
		
		Label lblGenerateMaze = new Label(shell, SWT.NONE);
		lblGenerateMaze.setText("Generate Type: ");
		
		Text txtGenerateMaze = new Text(shell, SWT.BORDER);
		txtGenerateMaze.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		Label lblSolutionAlg = new Label(shell, SWT.NONE);
		lblSolutionAlg.setText("Solution Algorithm: ");
		
		Text txtSolutionAlg = new Text(shell, SWT.BORDER);
		txtSolutionAlg.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		Label lblNumThreads = new Label(shell, SWT.NONE);
		lblNumThreads.setText("Number of Threads: ");
		
		Text txtNumThreads = new Text(shell, SWT.BORDER);
		txtNumThreads.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		Label lblViewStyle = new Label(shell, SWT.NONE);
		lblViewStyle.setText("View Style: ");
		
		Text txtViewStyle = new Text(shell, SWT.BORDER);
		txtViewStyle.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
				
		Button btnGenerateMaze = new Button(shell, SWT.PUSH);
		shell.setDefaultButton(btnGenerateMaze);
		btnGenerateMaze.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1));
		btnGenerateMaze.setText("Edit");
		
		btnGenerateMaze.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {				
				generateMaze=txtGenerateMaze.getText();
				solutionAlg=txtSolutionAlg.getText();
				numThreads = Integer.parseInt(txtNumThreads.getText());
				viewStyle=txtViewStyle.getText();
				displayInfo("Info","The Properties are:"+"\nGenerateType: "+generateMaze+"\nSolution Algorithm: "+solutionAlg
						+"\nNumber of Threads: "+numThreads + "\nView Style: " + viewStyle);
				shell.dispose();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});	
	}

	public String getGenerateMaze() {
		return generateMaze;
	}

	public String getSolutionAlg() {
		return solutionAlg;
	}

	public String getViewStyle() {
		return viewStyle;
	}

	public Integer getNumThreads() {
		return numThreads;
	}

	
	
}
