package Presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import Business.Maze;
import Business.Room;
import Framework.View;

/**
 * 
 * KK - created
 * KK - implemented MazeView(), draw()
 *
 */

public class MazeView extends View {

	public MazeView(Maze maze) {
		// TODO Auto-generated constructor stub
		super(maze);
	}
	
	public void draw(Graphics gc) {
		Maze maze = null;
		if(model instanceof Maze) { //Safe cast the model
			maze = (Maze)model;
		}

		int mazeSize = maze.getSize(); //get the size of the maze
		int width = this.getWidth(); //get the width
		int height = this.getHeight(); //get the height
		int exitColumn = maze.getExitColumn(); //get the exit column
		int exitRow = maze.getExitRow(); //get the exit row
		int playerRow = maze.getPlayerRow(); //get the player row
		int playerColumn = maze.getPlayerColumn(); //get the player column

		double roomW = (double)width/mazeSize; //Set the room width
		double roomH = (double)height/mazeSize; //Set the room height

		Graphics2D gc2d = (Graphics2D) gc;
		gc2d.setColor(Color.GRAY); //Set the color to grey
		gc2d.fillRect(0, 0, width, height); //fill with grey
		
		gc2d.setColor(Color.BLACK); //Set the color to black
	
		for(int r = 0; r < mazeSize; r++) {
			for(int c = 0; c < mazeSize; c++) {
				Rectangle2D.Double grid = new Rectangle2D.Double(r * roomW, c * roomH, roomW, roomH); //Make the grid
				gc2d.draw(grid); //draw the grid
			}
		}
		Ellipse2D.Double p = new Ellipse2D.Double(roomW * maze.getPlayerColumn() + roomW / 4, roomH * maze.getPlayerRow() + roomW / 4, roomW / 3, roomH / 3); //Create the player, sets the player in the middle of the correct room
		gc2d.setColor(Color.RED); //Set the player color to red
		gc2d.fill(p); //Fill the player with the color red

}
}
