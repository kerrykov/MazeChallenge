package Presentation;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Business.Maze;
import Framework.View;

/**
 * 
 * KK - created
 * KK - implemented ControlView
 *
 */

public class ControlView extends View{
	
	private Maze maze;
	private JTextField exitDistance;
	private JTextField movesLeft;
	private JButton northPanelButton;
	private JButton eastPanelButton;
	private JButton southPanelButton;
	private JButton westPanelButton;
	private JButton resetPanelButton;
	private MazeController mazeController;

	public ControlView(Maze maze) {
		this.maze = maze;
		mazeController = new MazeController(maze); //Sets the maze controller with the correct maze
		this.setLayout(new GridLayout(7,1)); //Sets the grid layout for seven components, one above the other
		
		JPanel exitDistancePanel = new JPanel();
		exitDistancePanel.add(new JLabel("Exit Distance")); //Add the label
		exitDistance = new JTextField("" + maze.distanceToExit(), 10); //Create the text field
		exitDistancePanel.add(exitDistance); //Add the text field
		
		JPanel movesLeftPanel = new JPanel();
		movesLeftPanel.add(new JLabel("Moves Left")); //Add the label
		movesLeft = new JTextField("" + maze.getPlayerMovesLeft(), 10); //Create the text field
		movesLeftPanel.add(movesLeft); //Add the text field
		
		JPanel northPanel = new JPanel();
		northPanelButton = new JButton("North"); //Set the North button
		northPanel.add(northPanelButton); //add the button to the panel
		
		JPanel eastPanel = new JPanel();
		eastPanelButton = new JButton("East"); //set the east button
		eastPanel.add(eastPanelButton); //add the button to the panel
		
		JPanel westPanel = new JPanel();
		westPanelButton = new JButton("West"); //set the west button
		westPanel.add(westPanelButton); //add the button to the panel
		
		JPanel southPanel = new JPanel();
		southPanelButton = new JButton("South"); //set the south button
		southPanel.add(southPanelButton); //add the button to the panel
		
		JPanel resetPanel = new JPanel();
		resetPanelButton = new JButton("Reset"); //set the reset button
		resetPanel.add(resetPanelButton); //add the button to the panel
		
		this.add(exitDistancePanel); //add the exit distance panel to the control view
		this.add(movesLeftPanel); //add the moves left panel to the control view
		this.add(northPanel); //add the north panel to the control view
		this.add(eastPanel); //add the east panel to the control view
		this.add(westPanel); //add the west panel to the control view
		this.add(southPanel); //add the south panel to the control view
		this.add(resetPanel); //add the reset panel to the control view
	}

}
