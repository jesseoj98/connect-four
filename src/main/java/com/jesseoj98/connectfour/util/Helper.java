package com.jesseoj98.connectfour.util;

import com.jesseoj98.connectfour.domain.GameBoard;

public class Helper {

	public boolean isSpaceAlreadyOccupied(char[] board, int space) {
		if (space < 0) {
			return false;
		}
		return board[space] == 'X' || board[space] == 'O';
	}

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
