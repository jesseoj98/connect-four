package com.jesseojones.connectfour.util;

public class Helper {

	private static final int PREVIOUS_SIMPLE_ROW = 7;

	private static final int SIMPLE_FLOOR = 35;

	public boolean isSpaceAlreadyOccupied(char space) {
		return space == 'X' || space == 'O';
	}

	public boolean isSimpleSpaceAlreadyOccupied(char[] board, int space) {
		return isSpaceAlreadyOccupied(board[space]);
	}

	public void insertIntoSimpleBoard(char[] board, int column, char insert) {
		int space = simpleFloorValue(column);
		if (!isSimpleSpaceAlreadyOccupied(board, space)) {
			insertIntoSimpleBoard(board, space, insert);
		} else {
			do {
				space = upOneSimpleRow(space);
				if (space < PREVIOUS_SIMPLE_ROW && isSimpleSpaceAlreadyOccupied(board, space)) {
					break;
				}
			} while (!isSimpleSpaceAlreadyOccupied(board, space));
			if (isSimpleSpaceAlreadyOccupied(board, space)) {
				System.out.println("Cannot insert, column full!");
			} else {
				insertIntoSimpleBoard(board, space, insert);
			}
		}
	}

	private int upOneSimpleRow(int value) {
		if (value < PREVIOUS_SIMPLE_ROW) {
			return value;
		} else {
			return value - PREVIOUS_SIMPLE_ROW;
		}
	}

	private int simpleFloorValue(int value) {
		return value + SIMPLE_FLOOR;
	}

}
