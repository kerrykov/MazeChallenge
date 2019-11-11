package Presentation;

import java.awt.GridLayout;
import Business.Maze;
import Framework.AppPanel;

/**
 * 
 * KK - created
 * KK - implemented MazePanel()
 *
 */

public class MazePanel extends AppPanel {
	
	private ControlView controlView;
	private MazeView mazeView;
	
	public MazePanel(Maze maze) {
		this.controlView = new ControlView(maze);
		this.mazeView = new MazeView(maze); 
		this.setLayout(new GridLayout(1, 2)); //Sets the grid layout
		this.add(controlView); //Adds the control view
		this.add(mazeView); //Adds the maze view with the correct maze
	}

}
