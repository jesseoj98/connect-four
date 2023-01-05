package com.jesseoj98.connectfour.util;

import java.util.List;
import java.util.Map;

import com.jesseoj98.connectfour.domain.BackwardDiagonal;
import com.jesseoj98.connectfour.domain.ForwardDiagonal;
import com.jesseoj98.connectfour.domain.GameBoard;
import com.jesseoj98.connectfour.domain.Result;

public class Validator {

	private static final Generator generator = new Generator();
	private static final Helper helper = new Helper();

	private static final List<Integer> invalidBackwardDiagonal = generator.generateInvalidBackwardDiagonalPositions();
	private static final List<Integer> invalidForwardDiagonal = generator.generateInvalidForwardDiagonalPositions();

	private static final Map<Integer, BackwardDiagonal> backwardDiagonalInformation = generator
			.generateBackwardDiagonalInformation();
	private static final Map<Integer, ForwardDiagonal> forwardDiagonalInformation = generator
			.generateForwardDiagonalInformation();

	public boolean connectFour(char[] board, int space) {
		if (space < 0) {
			return false;
		}
		boolean below = false;
		boolean above = false;
		boolean right = false;
		boolean left = false;
		boolean backwardDiagonal = false;
		boolean forwardDiagonal = false;
		if (space < 21) {
			// test below spaces
			below = checkDirection(board, space, GameBoard.BELOW, GameBoard.ABOVE);
		}
		if (space > 20) {
			// test above spaces
			above = checkDirection(board, space, GameBoard.ABOVE, GameBoard.BELOW);
		}
		if (space % GameBoard.LEVEL < 4) {
			// test right spaces
			right = checkDirection(board, space, GameBoard.LEFT, GameBoard.RIGHT);
		}
		if (space % GameBoard.LEVEL > 2) {
			// test left spaces
			left = checkDirection(board, space, GameBoard.RIGHT, GameBoard.LEFT);
		}
		if (!invalidBackwardDiagonal.contains(space)) {
			// test backward diagonal spaces
			backwardDiagonal = checkDirection(board, space, backwardDiagonalInformation.get(space).getMaxBelowRight(),
					backwardDiagonalInformation.get(space).getMaxAboveLeft(), GameBoard.BELOW_RIGHT,
					GameBoard.ABOVE_LEFT);
		}
		if (!invalidForwardDiagonal.contains(space)) {
			// test forward diagonal spaces
			forwardDiagonal = checkDirection(board, space, forwardDiagonalInformation.get(space).getMaxBelowLeft(),
					forwardDiagonalInformation.get(space).getMaxAboveRight(), GameBoard.BELOW_LEFT,
					GameBoard.ABOVE_RIGHT);
		}
		return below || above || right || left || backwardDiagonal || forwardDiagonal;
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

	private boolean checkDirection(char[] board, int space, int timesBelow, int timesAbove, int direction,
			int oppositeDirection) {
		final StringBuilder connectFour = new StringBuilder();
		int pointer = space;
		connectFour.append(board[space]);
		for (int i = 0; i < timesBelow; i++) {
			pointer += direction;
			connectFour.append(board[pointer]);
		}
		if (connectFour.length() == 4 && connectFour(connectFour.toString())) {
			return true;
		} else {
			pointer = space;
			for (int i = 0; i < timesAbove; i++) {
				pointer += oppositeDirection;
				connectFour.append(board[pointer]);
			}
			return connectFour.length() == 4 && connectFour(connectFour.toString());
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

	private boolean connectFour(String connectFour) {
		if (connectFour.length() != 4) {
			return false;
		}
		final char[] array = connectFour.toCharArray();
		final char c = array[0];
		for (int i = 1; i < array.length; i++) { // connectFour.length()
			if (!valueMatch(c, array[i])) {
				return false;
			}
		}
		return true;
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

	public boolean playAgain(char input) {
		return input == 'y' || input == 'Y';
	}

	public boolean letCpuGoFirst(char input) {
		return input == 'y' || input == 'Y';
	}

	public boolean isInputPlayingCharacterValid(char input) {
		return input == 'x' || input == 'X' || input == 'o' || input == 'O';
	}

	public boolean allGameBoardSpacesFilled(char[] gameBoard) {
		for (int i = 0; i < GameBoard.GAME_BOARD_SPACES; i++) {
			if (!helper.isSpaceAlreadyOccupied(gameBoard[i])) {
				return false;
			}
		}
		return true;
	}

	public void handleResult(boolean playerWon, boolean cpuWon, char[] gameBoard, char userPlayingCharacter,
			char cpuPlayingCharacter) {
		if (!playerWon && !cpuWon) {
			System.out.println("Tie!");
		} else {
			// to-do: get winning positions & print them
//			final Result result = new Result(playerWon, cpuWon,
//					retrieveWinningPositions(gameBoard, playerWon ? userPlayingCharacter : cpuPlayingCharacter), null);
//			printer.printResult(result);
			System.out.println();
		}
	}

}
