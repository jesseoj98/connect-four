package com.jesseojones.connectfour.util;

import com.jesseojones.connectfour.domain.GameBoard;

public class Helper {

	public boolean isSpaceAlreadyOccupied(char space) {
		return space == 'X' || space == 'O';
	}

	public boolean isSimpleSpaceAlreadyOccupied(char[] board, int space) {
		return isSpaceAlreadyOccupied(board[space]);
	}

	private void insertInputIntoSimpleBoard(char[] board, int space, char insert) {
		board[space] = insert;
	}

	public int insertIntoSimpleBoard(char[] board, int column, char insert) {
		int space = simpleFloorValue(column);
		if (!isSimpleSpaceAlreadyOccupied(board, space)) {
			insertIntoSimpleBoard(board, space, insert);
		} else {
			do {
				space = upOneSimpleRow(space);
				if (space < GameBoard.PREVIOUS_SIMPLE_ROW && isSimpleSpaceAlreadyOccupied(board, space)) {
					break;
				}
			} while (!isSimpleSpaceAlreadyOccupied(board, space));
			if (isSimpleSpaceAlreadyOccupied(board, space)) {
				System.out.println("Cannot insert, column full!");
			} else {
				insertInputIntoSimpleBoard(board, space, insert);
			}
		}
		return space;
	}

	private int upOneSimpleRow(int value) {
		if (value < GameBoard.PREVIOUS_SIMPLE_ROW) {
			return value;
		} else {
			return value - GameBoard.PREVIOUS_SIMPLE_ROW;
		}
	}

	private int simpleFloorValue(int value) {
		return value + GameBoard.SIMPLE_FLOOR;
	}

}
