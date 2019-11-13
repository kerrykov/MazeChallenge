package Presentation;

import Framework.*;
import Business.*;

/**
 * 
 * KK - created
 * JL - implemented execute(), MoveSouth()
 *
 */

public class MoveSouth extends Command {
	
	public MoveSouth(Maze maze) {
		model = maze;
	}
	
	public void execute() {
		((Maze) model).move(Heading.SOUTH);
	}

}
