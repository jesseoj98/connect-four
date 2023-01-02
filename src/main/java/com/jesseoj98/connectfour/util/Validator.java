package com.jesseoj98.connectfour.util;

import com.jesseoj98.connectfour.domain.GameBoard;

public class Validator {

	private boolean connectFour(char[] board, int space) {
		if (space > GameBoard.CEILING) {
			// test below adjacent space(s)
		}
		if (space < GameBoard.GAME_BOARD_SPACES) {
			return testAboveSpaces(board, space);
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

	private boolean testAboveSpaces(char[] board, int space) {
		if (space < 21) {
			return false;
		} else {
			final StringBuilder connectFour = new StringBuilder();
			int pointer = space;
			do {
				connectFour.append(board[pointer]);
				pointer = retrieveTopAdjacentSpace(pointer);
			} while (spaceMatch(board[space], board[pointer]));
			final String baseString = connectFour.toString().substring(0, connectFour.length() - 1);
			if (baseString.length() == 4) {
				return true;
			} else {
				return checkBelow(board, 4 - baseString.length(), space, baseString);
			}
		}
	}

	private boolean checkBelow(char[] board, int times, int space, String baseString) {
		final StringBuilder connectFour = new StringBuilder();
		for (int i = 0; i < times; i++) {
			space = retrieveBottomAdjacentSpace(space);
			connectFour.append(board[space]);
		}
		return connectFour.toString().length() + baseString.length() == 4;
	}

	private boolean spaceMatch(char space, char spaceToCheck) {
		return space == spaceToCheck;
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

	public boolean isInputValid(int input) {
		return input >= GameBoard.LOWER_BOUND && input <= GameBoard.UPPER_BOUND;
	}

}
