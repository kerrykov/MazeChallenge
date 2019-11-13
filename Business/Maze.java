package Business;

import java.lang.reflect.Array;
import Framework.*;
import java.lang.Math;
import java.util.*;

/**
 * 
 * KK - created
 * KK - implemented move(), getPlayerMovesLeft() and distanceToExit()
 * KK - implemented getSize(), getExitColumn(), getExitRow(), getPlayerRow(), getPlayerColumn()
 * SQ - fixed Maze(), implemented setPlayerRow(), setPlayerColumn()
 *
 */

public class Maze extends Model {
	private Room exit;
	private int movesLeft;
	private int exitRow;
	private int exitColumn;
	private int playerRow;
	private int playerColumn;
	private static int SIZE = 20;
	
	public Maze() {
		Random gen = new Random();
		Room[][] rooms = new Room[SIZE][SIZE]; //New 2d array of size
		for (int column = 0; column < SIZE; column++) { //initializes all the rooms
			for (int row = 0; row < SIZE; row++) {
				rooms[column][row] = new Room();
			}
		}
		//Selects a random room and makes it the exit
		this.exitRow = gen.nextInt(SIZE - 1) + 1;
		this.exitColumn = gen.nextInt(SIZE - 1) + 1;
		this.exit = (rooms[exitRow][exitColumn]);
		this.exit.setExit(true);
		//sets the player's location to (0,0)
		this.playerColumn = 0;
		this.playerRow = 0;
		//TODO calculate moves left
		this.movesLeft = distanceToExit() + gen.nextInt(5);
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
	
	//setter for the player row 
	public void setPlayerRow(int row) {
		this.playerRow = row;
	}
	
	//setter for the player column
	public void setPlayerColumn(int column) {
		this.playerColumn = column;
	}
	
	//getter for the number of moves left
	public int getPlayerMovesLeft() {
		return this.movesLeft;
	}
	
	public int getSize() {
		return SIZE;
	}
	
	//getter for the exit column
	public int getExitColumn() {
		return this.exitColumn;
	}
	
	//getter for the exit row
	public int getExitRow() {
		return this.exitRow;
	}
	
	//getter for the player row
	public int getPlayerRow() {
		return this.playerRow;
	}
	 //getter for the player column
	public int getPlayerColumn() {
		return this.playerColumn;
	}
}
