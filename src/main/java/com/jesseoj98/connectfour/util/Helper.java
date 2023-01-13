package com.jesseoj98.connectfour.util;

import com.jesseoj98.connectfour.domain.GameBoard;

/**
 * Helper class defines several helper methods
 */
public class Helper {

	/**
	 * Determines whether a space is already occupied or not using a space
	 * 
	 * @param space the space to check
	 * 
	 * @return whether the space is already occupied or not
	 */
	public boolean isSpaceAlreadyOccupied(char space) {
		return space == 'X' || space == 'O';
		// return space != ' ';
	}

	/**
	 * Determines whether a space is already occupied or not using the board and
	 * space
	 * 
	 * @param board the board to check
	 * @param space the space to check
	 * 
	 * @return whether the space is already occupied or not
	 */
	public boolean isSpaceAlreadyOccupied(char[] board, int space) {
		if (space < 0) {
			return false;
		}
		return isSpaceAlreadyOccupied(board[space]);
	}

	/**
	 * Inserts a playing character into the board at a given space
	 * 
	 * @param board  the board to insert into
	 * @param space  the index of the board to insert the character into
	 * @param insert the character to insert
	 */
	public void insertInputIntoBoard(char[] board, int space, char insert) {
		board[space] = insert;
	}

	/**
	 * Method that determines the top-most empty available space on a column in the
	 * board and returns that space's index
	 * 
	 * @param board  the board to check
	 * @param column the column to check
	 * 
	 * @return the index of the top-most empty available space on a column
	 */
	public int retrieveAvailableBoardSpace(char[] board, int column) {
		int space = column + GameBoard.FLOOR;
		if (isSpaceAlreadyOccupied(board, space)) {
			do {
				space = space + GameBoard.ABOVE;
				if (space < 0) {
					System.out.println("Cannot insert into column " + ((column % 6) + 1) + ", column full!");
					break;
				}
			} while (isSpaceAlreadyOccupied(board, space));
		}
		return space;
	}

}
