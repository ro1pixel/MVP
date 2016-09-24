package view;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerators.Position;

public class Maze2dDisplay extends MazeDisplay{

	Image startIm; 
	Image finishIm;
	Image characterIm;
	Image wallIm;

	Position characterPosition;
	final Color white;
	final Color black;

	public Maze2dDisplay(Composite parent, int style) {
		super(parent, style);
		
		startIm=new Image(getDisplay(),"./resources/start.jpg");
		finishIm=new Image(getDisplay(),"./resources/finish.jpg");
		characterIm=new Image(getDisplay(),"./resources/towelie.jpg");
		wallIm=new Image(getDisplay(),"./resources/wall.jpg");
		
		white=new Color(null, 255, 255, 255);
		black = new Color(null, 0, 0, 0);
		setBackground(white);
		
		addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent p) {
				
				if(maze!=null)
				{
					setCharacterPosition(maze.getStartPosition());
					
					p.gc.setForeground(new Color(null, 0, 0, 0));
					p.gc.setBackground(new Color(null, 35,50,120));

					int[][][] mazeData = maze.getMaze();
					

					int width = getSize().x;
					int depth = getSize().y;

					int w = width / mazeData[0][0].length;// the width of a cell
					int h = depth / mazeData[0].length; // the height of a cell

					// for calculating the size of the maze floor
					int lengthWidth = mazeData[0][0].length;// z axis length
					int lengthDepth = mazeData[0].length;// y axis length


					for (int i = 0; i < lengthDepth; i++) {
						for (int j = 0; j < lengthWidth; j++) {
					
							int pixelX = w * j;
							int pixelY = h * i;
							{
								p.gc.drawImage(wallIm, 0, 0, wallIm.getBounds().width,wallIm.getBounds().height,pixelX,pixelY ,w ,h);	//draw walls
							}

						}
					}
					if(characterPosition.equals(maze.getStartPosition())){
						p.gc.drawImage(startIm, 0, 0, startIm.getBounds().width,startIm.getBounds().height,maze.getStartPosition().getY(),maze.getStartPosition().getZ(),w,h);
						p.gc.setBackground(black);
					}
					else if(characterPosition.equals(maze.getGoalPosition())){
						p.gc.drawImage(finishIm, 0, 0, finishIm.getBounds().width,finishIm.getBounds().height,maze.getGoalPosition().getY(),maze.getGoalPosition().getZ(),w,h);
						p.gc.setBackground(black);
					}
					else
						p.gc.drawImage(characterIm, 0, 0, characterIm.getBounds().width,characterIm.getBounds().height,characterPosition.getY(),characterPosition.getZ(),w,h);
				
				}
			}
		});
	
	}
}
