package com.jesseojones.connectfour.util;

import com.jesseojones.connectfour.domain.GameBoard;

public class Helper {

	public boolean isSpaceAlreadyOccupied(char space) {
		return space == 'X' || space == 'O';
	}

	public boolean isSpaceAlreadyOccupied(char[] board, int space) {
		return isSpaceAlreadyOccupied(board[space]);
	}

	private void insertInputIntoBoard(char[] board, int space, char insert) {
		board[space] = insert;
	}

	public int insertIntoBoard(char[] board, int column, char insert) {
		int space = floorValue(column);
		if (!isSpaceAlreadyOccupied(board, space)) {
			insertInputIntoBoard(board, space, insert);
		} else {
			do {
				space = upOneRow(space);
			} while (space < 0 || !isSpaceAlreadyOccupied(board, space));
			if (space < 0 || !isSpaceAlreadyOccupied(board, space)) {
				System.out.println("Cannot insert, column full!");
			} else {
				insertInputIntoBoard(board, space, insert);
			}
		}
		return space;
	}

	private int upOneRow(int value) {
		return value - GameBoard.PREVIOUS_ROW;
	}

	private int floorValue(int value) {
		return value + GameBoard.FLOOR;
	}

}
