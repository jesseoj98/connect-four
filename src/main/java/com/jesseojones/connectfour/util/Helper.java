package com.jesseojones.connectfour.util;

public class Helper {

	private static final int PREVIOUS_SIMPLE_ROW = 7;

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

}
