package gui;
import java.awt.Graphics;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;

import algorithms.mazeGenerators.Position;

public class Character {
	private Position pos;
	private Image img;
	
	public Character() {
		img = new Image(null, "towelie.jpg");
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}
	
	public void draw(int cellWidth, int cellHeight, GC gc) {
		gc.drawImage(img, 0, 0, img.getBounds().width, img.getBounds().height, 
				cellWidth * pos.getX(), cellHeight * pos.getY(), cellWidth, cellHeight);
	}
	
	public void moveUp() {
		pos.setX(pos.getX()+2);
	}
	
	public void moveDown() {
		pos.setX(pos.getX()-2);
	}
	public void moveRight() {
		pos.setX(pos.getY()+2);
	}
	
	public void moveLeft() {
		pos.setX(pos.getY()-2);
	}
	public void moveForward() {
		pos.setX(pos.getZ()+2);
	}
	
	public void moveBack() {
		pos.setX(pos.getZ()-2);
	}

}
