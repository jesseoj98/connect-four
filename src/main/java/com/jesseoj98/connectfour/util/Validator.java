package com.jesseoj98.connectfour.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jesseoj98.connectfour.domain.GameBoard;
import com.jesseoj98.connectfour.domain.Result;
import com.jesseoj98.connectfour.domain.SpaceBounds;

/**
 * Validator class defines several helpful validation methods
 */
public class Validator {

	/** Instantiation of classes */
	private static final Generator generator = new Generator();
	private static final Helper helper = new Helper();
	private static final Printer printer = new Printer();

	/** Instantation of constants */
	private static final List<Integer> invalidBackwardDiagonal = generator.generateInvalidBackwardDiagonalPositions();
	private static final List<Integer> invalidForwardDiagonal = generator.generateInvalidForwardDiagonalPositions();

	private static final Map<Integer, SpaceBounds> horizontalInformation = generator.generateHorizontalInformation();
	private static final Map<Integer, SpaceBounds> verticalInformation = generator.generateVerticalInformation();
	private static final Map<Integer, SpaceBounds> backwardDiagonalInformation = generator
			.generateBackwardDiagonalInformation();
	private static final Map<Integer, SpaceBounds> forwardDiagonalInformation = generator
			.generateForwardDiagonalInformation();

	/**
	 * Checks whether or not a connect four has occured at a given space
	 * 
	 * @param board the board to check
	 * @param space the space to check
	 * @return whether or not a connect four has occured
	 */
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

	/**
	 * Checks whether a connect four String has formed using directions and amount
	 * of times to check each direction
	 * 
	 * @param board             the game board
	 * @param space             the space to use as a reference point
	 * @param timesBelow        the times to check below
	 * @param timesAbove        the times to check above
	 * @param direction         the direction to move
	 * @param oppositeDirection the opposite direction to move
	 * 
	 * @return whether a connect four String has formed
	 */
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

	/**
	 * Retrieves the winning positions
	 * 
	 * @param board             the board to get the positions off of
	 * @param space             the space where the win occurs
	 * @param timesBelow        the times to check below
	 * @param timesAbove        the times to check above
	 * @param direction         the direction to check
	 * @param oppositeDirection the opposite direction
	 * 
	 * @return the list of winning positions
	 */
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

	/**
	 * Checks whether all game board spaces are filled
	 * 
	 * @param gameBoard the game board to check
	 * 
	 * @return whether all game board spaces are filled
	 */
	public boolean allGameBoardSpacesFilled(char[] gameBoard) {
		for (int i = 0; i < GameBoard.GAME_BOARD_SPACES; i++) {
			if (!helper.isSpaceAlreadyOccupied(gameBoard[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Handles the result of the game
	 * 
	 * @param playerWon            whether the player won
	 * @param cpuWon               whether the cpu won
	 * @param gameBoard            the game board
	 * @param userPlayingCharacter the user playing character
	 * @param cpuPlayingCharacter  the cpu playing character
	 */
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

	/**
	 * Retrieves the winning positions by checking the winning spaces insertion
	 * point
	 * 
	 * @param board the board to get the winning positions off of
	 * @param space the space where the winning positions occurs
	 * 
	 * @return a list of a list of winning positions
	 */
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
