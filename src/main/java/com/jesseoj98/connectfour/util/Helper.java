package com.jesseoj98.connectfour.util;

import com.jesseoj98.connectfour.domain.GameBoard;

public class Helper {

	public boolean isSpaceAlreadyOccupied(char space) {
		return space == 'X' || space == 'O';
		// return space != ' ';
	}

	public boolean isSpaceAlreadyOccupied(char[] board, int space) {
		return isSpaceAlreadyOccupied(board[space]);
	}

	public void insertInputIntoBoard(char[] board, int space, char insert) {
		board[space] = insert;
	}

	public int retrieveAvailableBoardSpace(char[] board, int column) {
		int space = adjustValue(column, GameBoard.FLOOR);
		if (!isSpaceAlreadyOccupied(board, space)) {
			space = -1;
		} else {
			do {
				space = adjustValue(space, GameBoard.ABOVE);
			} while (space < 0 || !isSpaceAlreadyOccupied(board, space));
			if (space < 0 || !isSpaceAlreadyOccupied(board, space)) {
				System.out.println("Cannot insert, column full!");
			}
		}
		return space;
	}

	private int adjustValue(int value, int adjustment) {
		return value + adjustment;
	}

}
