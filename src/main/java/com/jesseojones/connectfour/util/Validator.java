package com.jesseojones.connectfour.util;

import com.jesseojones.connectfour.domain.GameBoard;

public class Validator {

	private boolean connectFour(char[] board, int space) {
		if (space > GameBoard.CEILING) {
			// test below adjacent space(s)
		}
		if (space < GameBoard.FLOOR) {
			// test above adjacent spaces(s)
		}
		if (space % GameBoard.LEVEL == 0) {
			if (valueMatch(board[space], board[retrieveRightAdjacentSpace(space)])) {
				// test right adjacent space(s)
			}
		}
		if (space % GameBoard.LEVEL == 6) {
			if (valueMatch(board[space], board[retrieveLeftAdjacentSpace(space)])) {
				// test left adjacent space(s)
			}
		}
		if (space > GameBoard.CEILING && space % GameBoard.LEVEL == 0) {
			// test bottom-right adjacent space(s)
		}
		if (space < GameBoard.FLOOR && space % GameBoard.LEVEL == 6) {
			// test above-right adjacent space(s)
		}
		return false;
	}

	private int retrieveTopAdjacentSpace(int value) {
		return value + GameBoard.LEVEL;
	}

	private int retrieveRightAdjacentSpace(int value) {
		return value + GameBoard.BESIDE;
	}

	private int retrieveBottomAdjacentSpace(int value) {
		return value - GameBoard.LEVEL;
	}

	private int retrieveLeftAdjacentSpace(int value) {
		return value - GameBoard.BESIDE;
	}

	private int retrieveTopLeftAdjacentSpace(int value) {
		return value - GameBoard.BACKWARD_DIAGONAL;
	}

	private int retrieveTopRightAdjacentSpace(int value) {
		return value - GameBoard.FORWARD_DIAGONAL;
	}

	private int retrieveBottomRightAdjacentSpace(int value) {
		return value + GameBoard.BACKWARD_DIAGONAL;
	}

	private int retrieveBottomLeftAdjacentSpace(int value) {
		return value + GameBoard.FORWARD_DIAGONAL;
	}

	private boolean valueMatch(char insert, char adjacentValue) {
		return insert == adjacentValue;
	}

}
