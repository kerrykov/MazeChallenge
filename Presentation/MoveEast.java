package Presentation;

import Business.*;
import Framework.*;

/**
 * 
 * KK - created
 * JL - implemented execute(), MoveEast()
 *
 */

public class MoveEast extends Command {

	public MoveEast(Maze maze) {
		model = maze;
	}

	public void execute() {
		((Maze) model).move(Heading.EAST);
	}
	
}