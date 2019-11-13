package Presentation;

import Framework.*;
import Business.*;

/**
 * 
 * KK - created
 * JL - implemented MoveWest(), execute()
 *
 */

public class MoveWest extends Command {
	
	public MoveWest(Maze maze) {
		model = maze;
	}
	
	public void execute() {
		((Maze) model).move(Heading.WEST);
	}
}
