package Presentation;

import Business.Heading;
import Business.Maze;
import Framework.Command;

/**
 * 
 * KK - created
 * KK - implemented execute()
 *
 */

public class MoveEast extends Command {
	Maze maze;
	Heading direction;
	
	public MoveEast(Maze maze) {
		
	}

	public void execute() {
		maze.move(direction.EAST);
	}
	
}