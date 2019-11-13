package Presentation;

import java.awt.event.ActionListener;

import Business.*;
import Framework.*;

/**
 * 
 * KK - created
 * JL - implemented makeModel(), makePanel(), getEditCommands(), makeEditCommand(), getTitle(), getHelp(), about()
 * JL - fixed makePanel(), makeEditCommand()
 *
 */

public class MazeFactory implements AppFactory {
	
	@Override
	public Model makeModel() {
		return new Maze();
	}

	
	
	@Override
	public AppPanel makePanel(Model model, ActionListener listener) {
		return new MazePanel((Maze) model, listener);
	}
	
	

	@Override
	public String[] getEditCommands() {
		String[] commands = { "North", "South", "East", "West", "Reset" };
		return commands;
	}
	//UNFINISHED: NEED COMMAND CLASSES
	@Override
	public Command makeEditCommand(Model model, String type) {
		Maze maze = (Maze) model;
		
		if (type == "North") {
			return new MoveNorth(maze); 		// These are the commands
		}
		else if (type == "South") {
			return new MoveSouth(maze); 		// These are the commands	
		}
		else if (type == "East") {
			return new moveEast(maze); 		// These are the commands
		}
		else if (type == "West") {
			return new moveWest(maze);// These are the commands
		}
		else if (type == "Reset") {
			return new reset(maze); 		// These are the commands
		}
		return null;
	}
	// UNFINISHED
	@Override
	public String getTitle() {
		String title = "Maze Challenge V1.0";
		return title;
	}

	@Override
	public String[] getHelp() {
		String[] help = { "Locate the escape room in the number of allocated moves" };
		return help;
	}

	@Override
	public String about() {
		String about = "Maze Challenge V1.0 by Lynx 2019";
		return about;
	}

}
