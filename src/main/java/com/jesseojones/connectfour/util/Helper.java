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
