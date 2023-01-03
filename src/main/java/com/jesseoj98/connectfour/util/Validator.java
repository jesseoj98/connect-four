package com.jesseoj98.connectfour.util;

import com.jesseoj98.connectfour.domain.GameBoard;

public class Validator {

	private boolean connectFour(char[] board, int space) {
		if (space < 0) {
			return false;
		}
		boolean below = false;
		boolean above = false;
		boolean right = false;
		boolean left = false;
		boolean forwardDiagonal = false;
		boolean backwardDiagonal = false;
		if (space > GameBoard.CEILING) {
			// test below adjacent space(s)
		}
		if (space > 20) {
			return testAboveSpaces(board, space);
		}
		if (space % GameBoard.LEVEL == 0) {
			if (valueMatch(board[space], board[retrieveAdjacentSpace(space, GameBoard.RIGHT)])) {
				// test right adjacent space(s)
			}
		}
		if (space % GameBoard.LEVEL == 6) {
			if (valueMatch(board[space], board[retrieveAdjacentSpace(space, GameBoard.LEFT)])) {
				// test left adjacent space(s)
			}
		}
		if (space > GameBoard.CEILING && space % GameBoard.LEVEL == 0) {
			// test bottom-right adjacent space(s)
		}
		if (space < GameBoard.FLOOR && space % GameBoard.LEVEL == 6) {
			// test above-right adjacent space(s)
		}
		return below || above || right || left || forwardDiagonal || backwardDiagonal;
	}

	private boolean testAboveSpaces(char[] board, int space) {
		final StringBuilder connectFour = new StringBuilder();
		int pointer = space;
		do {
			connectFour.append(board[pointer]);
			pointer = retrieveAdjacentSpace(pointer, GameBoard.ABOVE);
		} while (spaceMatch(board[space], board[pointer]));
		final String baseString = connectFour.toString().substring(0, connectFour.length() - 1);
		if (baseString.length() == 4) {
			return true;
		} else {
			return checkBelow(board, 4 - baseString.length(), space, baseString);
		}
	}

	private boolean checkBelow(char[] board, int times, int space, String baseString) {
		final StringBuilder connectFour = new StringBuilder();
		for (int i = 0; i < times; i++) {
			space = retrieveAdjacentSpace(space, GameBoard.BELOW);
			connectFour.append(board[space]);
		}
		return connectFour.toString().length() + baseString.length() == 4;
	}

	private boolean spaceMatch(char space, char spaceToCheck) {
		return space == spaceToCheck;
	}

	private int retrieveAdjacentSpace(int value, int adjustment) {
		return value + adjustment;
	}

	private boolean valueMatch(char insert, char adjacentValue) {
		return insert == adjacentValue;
	}

	public boolean isInputValid(int input) {
		return input >= GameBoard.LOWER_BOUND && input <= GameBoard.UPPER_BOUND;
	}

}
