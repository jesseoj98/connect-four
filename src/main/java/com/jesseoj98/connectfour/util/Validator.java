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
		if (space < 21) {
			return checkDirection(board, space, GameBoard.BELOW, GameBoard.ABOVE);
		}
		if (space > 20) {
			return checkDirection(board, space, GameBoard.ABOVE, GameBoard.BELOW);
		}
		if (space % GameBoard.LEVEL < 4) {
			return checkDirection(board, space, GameBoard.LEFT, GameBoard.RIGHT);
		}
		if (space % GameBoard.LEVEL > 2) {
			return checkDirection(board, space, GameBoard.RIGHT, GameBoard.LEFT);
		}
		if (space > 13 && space % GameBoard.LEVEL < 4) {
			return checkDirection(board, space, GameBoard.BELOW_RIGHT, GameBoard.ABOVE_LEFT);
		}
		if (space > 13 && space % GameBoard.LEVEL > 2) {
			return checkDirection(board, space, GameBoard.BELOW_RIGHT, GameBoard.ABOVE_LEFT);
		}
		return below || above || right || left || forwardDiagonal || backwardDiagonal;
	}

	private boolean checkDirection(char[] board, int space, int direction, int oppositeDirection) {
		final StringBuilder connectFour = new StringBuilder();
		int pointer = space;
		do {
			connectFour.append(board[pointer]);
			pointer = retrieveAdjacentSpace(pointer, direction);
		} while (valueMatch(board[space], board[pointer]));
		final String baseString = connectFour.toString().substring(0, connectFour.length() - 1);
		if (baseString.length() == 4) {
			return true;
		} else {
			return checkOppositeDirection(board, oppositeDirection, 4 - baseString.length(), space, baseString);
		}
	}

	private boolean checkOppositeDirection(char[] board, int oppositeDirection, int times, int space,
			String baseString) {
		final StringBuilder connectFour = new StringBuilder();
		for (int i = 0; i < times; i++) {
			space = retrieveAdjacentSpace(space, oppositeDirection);
			connectFour.append(board[space]);
		}
		return connectFour.toString().length() + baseString.length() == 4;
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
