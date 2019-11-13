package Presentation;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Business.*;
import Framework.*;

/**
 * 
 * KK - created
 * KK - implemented ControlView
 * JL - added actionListeners to ControlView and implemented the nested MazeController
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
	private MazeController mazeController = new MazeController();

	public ControlView(Maze maze) {
		this.maze = maze;
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
		northPanelButton.addActionListener(mazeController);
		northPanel.add(northPanelButton); //add the button to the panel
		
		JPanel eastPanel = new JPanel();
		eastPanelButton = new JButton("East"); //set the east button
		eastPanelButton.addActionListener(mazeController);
		eastPanel.add(eastPanelButton); //add the button to the panel
		
		JPanel westPanel = new JPanel();
		westPanelButton = new JButton("West"); //set the west button
		westPanelButton.addActionListener(mazeController);
		westPanel.add(westPanelButton); //add the button to the panel
		
		JPanel southPanel = new JPanel();
		southPanelButton = new JButton("South"); //set the south button
		southPanelButton.addActionListener(mazeController);
		southPanel.add(southPanelButton); //add the button to the panel
		
		JPanel resetPanel = new JPanel();
		resetPanelButton = new JButton("Reset"); //set the reset button
		resetPanelButton.addActionListener(mazeController);
		resetPanel.add(resetPanelButton); //add the button to the panel
		
		this.add(exitDistancePanel); //add the exit distance panel to the control view
		this.add(movesLeftPanel); //add the moves left panel to the control view
		this.add(northPanel); //add the north panel to the control view
		this.add(eastPanel); //add the east panel to the control view
		this.add(westPanel); //add the west panel to the control view
		this.add(southPanel); //add the south panel to the control view
		this.add(resetPanel); //add the reset panel to the control view
	}
	
	// Nested Class
	private class MazeController implements ActionListener {
		String error = "";					// Stores error message
		@Override
		public void actionPerformed(ActionEvent e) {
			// Tests North Button
			if (e.getSource() == northPanelButton) {
				try {
					// Try to move north
					if (maze.getPlayerRow() == 0) {
						throw new Exception(); 
					}						
					// Command to move north
					CommandProcessor.execute(new MoveNorth(maze));
				}
				// Print Error Message
				catch (Exception exception) {
					error = "You cannot move north";
					JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.ERROR_MESSAGE);
				}	
			}
			// Tests South Button
			else if (e.getSource() == southPanelButton) {
				try {
					// Try to move south
					if (maze.getPlayerRow() == maze.getSize() - 1) {
						throw new Exception(); 
					}
					// Command to move south
					CommandProcessor.execute(new MoveSouth(maze));	
				}	
				// Print Error Message
				catch (Exception exception) {
					error = "You cannot move south";
					JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			// Tests East Button
			else if (e.getSource() == eastPanelButton) {
				try {
					// Try to move east
					if (maze.getPlayerColumn() == maze.getSize() - 1) {
						throw new Exception(); 
					}	
					// Command to move east
					CommandProcessor.execute(new MoveEast(maze));										
				}	
				// Print Error Message
				catch (Exception exception) {
					error = "You cannot move east";
					JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			// Tests West Button
			else if (e.getSource() == westPanelButton) {
				try {
					// Try to move west
					if (maze.getPlayerColumn() == 0) {
						throw new Exception(); 
					}
					// Command to move west
					CommandProcessor.execute(new MoveWest(maze));																
				}	
				// Print Error Message
				catch (Exception exception) {
					error = "You cannot move west";
					JOptionPane.showMessageDialog(null, error, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			// Tests Reset Button
			else if (e.getSource() == resetPanelButton) {	
				// Command to reset
				CommandProcessor.execute(new Reset(maze));														
			}
		}	// End of actionPerformed
	}	// End of MazeController
}
