package Presentation;

import Framework.*;
import Business.*;

/**
 * 
 * KK - created
 * JL - implemented execute(), MoveNorth()
 *
 */

public class MoveNorth extends Command {
	
	public MoveNorth(Maze maze) {
		model = maze;
	}

	public void execute() {
		((Maze) model).move(Heading.NORTH);
	}
}
