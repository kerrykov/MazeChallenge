package Business;

import java.lang.reflect.Array;

import Framework.Model;

import java.lang.Math;

/**
 * 
 * KK - created
 * KK - implemented move(), getPlayerMovesLeft() and distanceToExit()
 * KK - added getSize(), getExitColumn(), getExitRow(), getPlayerRow(), getPlayerColumn()
 *
 */

public class Maze extends Model {
	private Room exit;
	private int movesLeft;
	private int exitRow;
	private int exitColumn;
	private int playerRow;
	private int playerColumn;
	private static int SIZE;
	
	public Maze() {
		Room[][] rooms = new Room[SIZE][SIZE]; //New 2d array of size
	}
	
	public void move(Heading direction) {
		switch (direction) { //Depending on the direction, player moves
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
	
	public int distanceToExit() { //returns the exit distance to be displayed
		return (int)Math.floor(Math.sqrt((exitRow - playerRow)^2 + (exitColumn - playerColumn)^2));
	}
	
	public int getPlayerMovesLeft() {
		return movesLeft;
	}
	
	public int getSize() {
		return SIZE;
	}
	
	public int getExitColumn() {
		return exitColumn;
	}
	
	public int getExitRow() {
		return exitRow;
	}
	
	public int getPlayerRow() {
		return playerRow;
	}
	
	public int getPlayerColumn() {
		return playerColumn;
	}
}
