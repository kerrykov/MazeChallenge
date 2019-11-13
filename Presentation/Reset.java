package Presentation;

import Framework.*;
import Business.*;

/**
 * 
 * KK - created
 * JL - implemented Reset()
 *
 */

public class Reset extends Command {
	
	public Reset(Maze maze) {
		model = maze;
	}
	
	public void execute() {
		//((Maze) model).RESETFUNCTION;
	}

}
