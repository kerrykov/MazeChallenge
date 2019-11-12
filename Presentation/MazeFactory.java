package Presentation;

import java.awt.event.ActionListener;

import Business.*;
import Framework.*;

/**
 * 
 * KK - created
 * JL - implemented makeModel(), makePanel(), getEditCommands(), makeEditCommand(), getTitle(), getHelp(), about()
 *
 */

public class MazeFactory implements AppFactory {
	
	@Override
	public Model makeModel() {
		return new Maze();
	}

	
	
	// NEEDS MAZEPANEL
	@Override
	public AppPanel makePanel(Model model, ActionListener listener) {
		return new MazePanel(model, listener);
	}
	//NEEDS MAZEPANEL
	
	

	@Override
	public String[] getEditCommands() {
		String[] commands = { "North", "South", "East", "West", "Reset" };
		return commands;
	}
	//UNFINISHED: NEED COMMAND CLASSES
	@Override
	public Command makeEditCommand(Model model, String type) {
		if (type == "North") {
		//	return new SetNorth(model); 		// These are the commands
		}
		else if (type == "South") {
		//	return new SetNorth(model); 		// These are the commands	
		}
		else if (type == "East") {
		//	return new SetNorth(model); 		// These are the commands
		}
		else if (type == "West") {
			//	return new SetNorth(model); 		// These are the commands
		}
		else if (type == "Reset") {
			//	return new SetNorth(model); 		// These are the commands
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
