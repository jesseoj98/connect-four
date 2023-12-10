package com.jesseoj98.connectfour.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jesseoj98.connectfour.domain.GameBoard;
import com.jesseoj98.connectfour.domain.Result;
import com.jesseoj98.connectfour.domain.SpaceBounds;

public class Validator {

	private static final Generator generator = new Generator();
	private static final Helper helper = new Helper();
	private static final Printer printer = new Printer();

	private static final Set<Integer> invalidBackwardDiagonal = generator.generateInvalidBackwardDiagonalPositions();
	private static final Set<Integer> invalidForwardDiagonal = generator.generateInvalidForwardDiagonalPositions();

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
		if (space < 21) {
			vertical = checkDirection(board, space, verticalInformation.get(space).getMaxBelow(),
					verticalInformation.get(space).getMaxAbove(), GameBoard.BELOW, GameBoard.ABOVE);
		}

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
		if (connectFour.toString().length() > 3) {
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
		return connectFour.toString().length() > 3;
	}

	private List<Integer> retrievePositions(char[] board, int space, int timesBelow, int timesAbove, int direction,
			int oppositeDirection) {
		final List<Integer> connectFour = new ArrayList<>();
		int pointer = space;
		connectFour.add(space);
		for (int i = 0; i < timesBelow; i++) {
			pointer += direction;
			if (board[space] == board[pointer]) {
				connectFour.add(pointer);
			} else {
				break;
			}
		}
		pointer = space;
		for (int i = 0; i < timesAbove; i++) {
			pointer += oppositeDirection;
			if (board[space] == board[pointer]) {
				connectFour.add(pointer);
			} else {
				break;
			}
		}
		return connectFour;
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
			char cpuPlayingCharacter, int userInsertionPoint, int cpuInsertionPoint) {
		if (!playerWon && !cpuWon) {
			System.out.println("Tie!");
		} else {
			final Result result = new Result(cpuWon, playerWon,
					retrieveWinningPositions(gameBoard, playerWon ? userInsertionPoint : cpuInsertionPoint));
			printer.printResult(result);
			System.out.println();
		}
	}

	private List<List<Integer>> retrieveWinningPositions(char[] board, int space) {
		final List<List<Integer>> winningPositions = new ArrayList<>();
		if (checkDirection(board, space, horizontalInformation.get(space).getMaxBelow(),
				horizontalInformation.get(space).getMaxAbove(), GameBoard.RIGHT, GameBoard.LEFT)) {
			winningPositions.add(retrievePositions(board, space, horizontalInformation.get(space).getMaxBelow(),
					horizontalInformation.get(space).getMaxAbove(), GameBoard.RIGHT, GameBoard.LEFT));
		}
		if (checkDirection(board, space, verticalInformation.get(space).getMaxBelow(),
				verticalInformation.get(space).getMaxAbove(), GameBoard.BELOW, GameBoard.ABOVE)) {
			winningPositions.add(retrievePositions(board, space, verticalInformation.get(space).getMaxBelow(),
					verticalInformation.get(space).getMaxAbove(), GameBoard.BELOW, GameBoard.ABOVE));
		}
		if (!invalidBackwardDiagonal.contains(space) && checkDirection(board, space,
				backwardDiagonalInformation.get(space).getMaxBelow(),
				backwardDiagonalInformation.get(space).getMaxAbove(), GameBoard.BELOW_RIGHT, GameBoard.ABOVE_LEFT)) {
			winningPositions.add(retrievePositions(board, space, backwardDiagonalInformation.get(space).getMaxBelow(),
					backwardDiagonalInformation.get(space).getMaxAbove(), GameBoard.BELOW_RIGHT, GameBoard.ABOVE_LEFT));
		}
		if (!invalidForwardDiagonal.contains(space) && checkDirection(board, space,
				forwardDiagonalInformation.get(space).getMaxBelow(),
				forwardDiagonalInformation.get(space).getMaxAbove(), GameBoard.BELOW_LEFT, GameBoard.ABOVE_RIGHT)) {
			winningPositions.add(retrievePositions(board, space, forwardDiagonalInformation.get(space).getMaxBelow(),
					forwardDiagonalInformation.get(space).getMaxAbove(), GameBoard.BELOW_LEFT, GameBoard.ABOVE_RIGHT));
		}
		return winningPositions;
	}

}
