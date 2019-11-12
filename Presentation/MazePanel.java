package Presentation;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import Business.Maze;
import Framework.AppPanel;
import Framework.Model;

/**
 * 
 * KK - created
 * KK - implemented MazePanel()
 * JL - added actionListeners to MazePanel()
 *
 */

public class MazePanel extends AppPanel {
	
	private ControlView controlView;
	private MazeView mazeView;
	
	public MazePanel(Maze maze, ActionListener listener) {
		super(maze, listener);
		this.controlView = new ControlView(maze);
		this.mazeView = new MazeView(maze); 
		this.setLayout(new GridLayout(1, 2)); //Sets the grid layout
		this.add(controlView); //Adds the control view
		this.add(mazeView); //Adds the maze view with the correct maze
	}

}
