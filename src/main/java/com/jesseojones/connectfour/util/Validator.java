package com.jesseojones.connectfour.util;

public class Validator {

	private static final int BESIDE = 1;

	private static final int CEILING = 6;

	private static final int FORWARD_DIAGONAL = 6;

	private static final int LEVEL = 7;

	private static final int BACKWARD_DIAGONAL = 8;

	private static final int FLOOR = 35;

	private boolean connectFour(char[] board, int space) {
		if (space > CEILING) {
			// test below adjacent space(s)
		}
		if (space < FLOOR) {
			// test above adjacent spaces(s)
		}
		if (space % LEVEL == 0) {
			if (valueMatch(board[space], board[retrieveRightAdjacentSpace(space)])) {
				// test right adjacent space(s)
			}
		}
		if (space % LEVEL == 6) {
			if (valueMatch(board[space], board[retrieveLeftAdjacentSpace(space)])) {
				// test left adjacent space(s)
			}
		}
		if (space > CEILING && space % LEVEL == 0) {
			// test bottom-right adjacent space(s)
		}
		if (space < FLOOR && space % LEVEL == 6) {
			// test above-right adjacent space(s)
		}
		return false;
	}

	private int retrieveTopAdjacentSpace(int value) {
		return value + LEVEL;
	}

	private int retrieveRightAdjacentSpace(int value) {
		return value + BESIDE;
	}

	private int retrieveBottomAdjacentSpace(int value) {
		return value - LEVEL;
	}

	private int retrieveLeftAdjacentSpace(int value) {
		return value - BESIDE;
	}

	private int retrieveTopLeftAdjacentSpace(int value) {
		return value - BACKWARD_DIAGONAL;
	}

	private int retrieveTopRightAdjacentSpace(int value) {
		return value - FORWARD_DIAGONAL;
	}

	private int retrieveBottomRightAdjacentSpace(int value) {
		return value + BACKWARD_DIAGONAL;
	}

	private int retrieveBottomLeftAdjacentSpace(int value) {
		return value + FORWARD_DIAGONAL;
	}

	private boolean valueMatch(char insert, char adjacentValue) {
		return insert == adjacentValue;
	}

}
