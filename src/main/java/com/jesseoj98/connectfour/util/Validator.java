package com.jesseoj98.connectfour.util;

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
	 * to-do: finish method
	 * 
	 * Handles result of the game
	 * 
	 * @param playerWon            whether the player won
	 * @param cpuWon               whether the cpu won
	 * @param gameBoard            the game board
	 * @param userPlayingCharacter the user playing character
	 * @param cpuPlayingCharacter  the cpu playing character
	 */
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
