package Business;

import java.lang.reflect.Array;
import java.lang.Math;

public class Maze {
	private Room exit;
	private int movesLeft;
	private int exitRow;
	private int exitColumn;
	private int playerRow;
	private int playerColumn;
	private static int SIZE;
	
	public Maze() {
		Room[][] rooms = new Room[SIZE][SIZE];
	}
	
	public void move(Heading direction) {
		switch (direction) {
		case NORTH: 
			if (playerRow != 0) {
				playerRow -= 1;
			}
			break;
		case SOUTH:
			if (playerRow != SIZE - 1) {
				playerRow += 1;
			}
			break;
		case EAST:
			if (playerColumn != SIZE - 1) {
				playerColumn += 1;
			}
			break;
		case WEST:
			if (playerColumn != 0) {
				playerColumn -= 1;
			}
			break;
		}
		}
	
	public int distanceToExit() {
		return (int)Math.floor(Math.sqrt((exitRow - playerRow)^2 + (exitColumn - playerColumn)^2));
	}
}
