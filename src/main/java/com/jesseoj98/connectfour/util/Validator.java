package com.jesseoj98.connectfour.util;

import java.util.List;
import java.util.Map;

import com.jesseoj98.connectfour.domain.GameBoard;
import com.jesseoj98.connectfour.domain.Result;
import com.jesseoj98.connectfour.domain.SpaceBounds;

public class Validator {

	private static final Generator generator = new Generator();
	private static final Helper helper = new Helper();

	private static final List<Integer> invalidBackwardDiagonal = generator.generateInvalidBackwardDiagonalPositions();
	private static final List<Integer> invalidForwardDiagonal = generator.generateInvalidForwardDiagonalPositions();

	private static final Map<Integer, SpaceBounds> horizontalInformation = generator.generateHorizontalInformation();
	private static final Map<Integer, SpaceBounds> verticalInformation = generator.generateVerticalInformation();
	private static final Map<Integer, SpaceBounds> backwardDiagonalInformation = generator
			.generateBackwardDiagonalInformation();
	private static final Map<Integer, SpaceBounds> forwardDiagonalInformation = generator
			.generateForwardDiagonalInformation();

	public boolean connectFour(char[] board, int space) {
		if (space < 0) {
			return false;
		}
		boolean horizontal = false;
		boolean vertical = false;
		boolean backwardDiagonal = false;
		boolean forwardDiagonal = false;

		horizontal = checkDirection(board, space, horizontalInformation.get(space).getMaxBelow(),
				horizontalInformation.get(space).getMaxAbove(), GameBoard.RIGHT, GameBoard.LEFT);
		vertical = checkDirection(board, space, verticalInformation.get(space).getMaxBelow(),
				verticalInformation.get(space).getMaxAbove(), GameBoard.BELOW, GameBoard.ABOVE);

		if (!invalidBackwardDiagonal.contains(space)) {
			// test backward diagonal spaces
			backwardDiagonal = checkDirection(board, space, backwardDiagonalInformation.get(space).getMaxBelow(),
					backwardDiagonalInformation.get(space).getMaxAbove(), GameBoard.BELOW_RIGHT, GameBoard.ABOVE_LEFT);
		}
		if (!invalidForwardDiagonal.contains(space)) {
			// test forward diagonal spaces
			forwardDiagonal = checkDirection(board, space, forwardDiagonalInformation.get(space).getMaxBelow(),
					forwardDiagonalInformation.get(space).getMaxAbove(), GameBoard.BELOW_LEFT, GameBoard.ABOVE_RIGHT);
		}
		return vertical || horizontal || backwardDiagonal || forwardDiagonal;
	}

	private boolean checkDirection(char[] board, int space, int timesBelow, int timesAbove, int direction,
			int oppositeDirection) {
		final StringBuilder connectFour = new StringBuilder();
		int pointer = space;
		connectFour.append(board[space]);
		for (int i = 0; i < timesBelow; i++) {
			pointer += direction;
			if (board[space] == board[pointer]) {
				connectFour.append(board[pointer]);
			} else {
				break;
			}
		}
		if (connectFour.toString().length() == 4) {
			return true;
		}
		pointer = space;
		for (int i = 0; i < timesAbove; i++) {
			pointer += oppositeDirection;
			if (board[space] == board[pointer]) {
				connectFour.append(board[pointer]);
			} else {
				break;
			}
		}
		return connectFour.toString().length() == 4;
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
