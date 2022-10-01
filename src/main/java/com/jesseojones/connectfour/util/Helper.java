package com.jesseojones.connectfour.util;

public class Helper {

	public boolean isSpaceAlreadyOccupied(char space) {
		return space == 'X' || space == 'O';
	}

	public boolean isSimpleSpaceAlreadyOccupied(char[] board, int space) {
		return isSpaceAlreadyOccupied(board[space]);
	}

}
