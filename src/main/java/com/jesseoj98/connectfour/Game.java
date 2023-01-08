package com.jesseoj98.connectfour;

import java.util.Scanner;

import com.jesseoj98.connectfour.domain.GameBoard;
import com.jesseoj98.connectfour.util.Generator;
import com.jesseoj98.connectfour.util.Helper;
import com.jesseoj98.connectfour.util.Printer;
import com.jesseoj98.connectfour.util.Validator;

/**
 * Game class plays the Connect Four game
 */
public class Game {

	/** Instantiation of classes */
	private static final Generator generator = new Generator();
	private static final Helper helper = new Helper();
	private static final Printer printer = new Printer();
	private static final Scanner scanner = new Scanner(System.in);
	private static final Validator validator = new Validator();

	/**
	 * Preliminary setup class before playing Connect Four game
	 */
	public void playGame() {

		char userInput;
		char userPlayingCharacter;
		boolean letCpuGoFirst;

		System.out.println("Connect Four by Jesse Jones\n");

		System.out.print("Choose X or O: ");

		do {
			userInput = scanner.next().charAt(0);
		} while (!(userInput == 'x' || userInput == 'X' || userInput == 'o' || userInput == 'O'));

		userPlayingCharacter = Character.toUpperCase(userInput);

		char cpuPlayingCharacter = userPlayingCharacter == 'X' ? 'O' : 'X';

		System.out.print("Let the CPU go first? (y/n): ");

		do {
			userInput = scanner.next().charAt(0);
		} while (!(userInput == 'y' || userInput == 'Y' || userInput == 'n' || userInput == 'N'));

		letCpuGoFirst = userInput == 'y' || userInput == 'Y';

		playGame(userPlayingCharacter, cpuPlayingCharacter, letCpuGoFirst);

		System.out.print("\nPlay again? (y/n): ");
	}

	/**
	 * Class that actually plays the Connect Four game
	 * 
	 * @param userPlayingCharacter the user playing character
	 * @param cpuPlayingCharacter  the cpu playing character
	 * @param letCpuGoFirst        whether the cpu should go first
	 */
	private void playGame(char userPlayingCharacter, char cpuPlayingCharacter, boolean letCpuGoFirst) {

		int userInput;
		int cpuInput;
		int userInsertionPoint;
		// it's not possible to break out of the game early without this
		// getting initialized at least once but Java still wants this initialized
		int cpuInsertionPoint = 0;

		final char[] gameBoard = generator.generateGameBoard();

		if (letCpuGoFirst) {
			final int cpuFirstPlay = generator.generateRandomInput();
			helper.insertInputIntoBoard(gameBoard, helper.retrieveAvailableBoardSpace(gameBoard, cpuFirstPlay - 1),
					cpuPlayingCharacter);
		}

		System.out.println();
		printer.printGameBoard(gameBoard);

		do {

			System.out.print("\nEnter a spot to place your move: ");

			do {
				userInput = scanner.nextInt();
			} while ((!(userInput >= GameBoard.LOWER_BOUND && userInput <= GameBoard.UPPER_BOUND) && helper
					.isSpaceAlreadyOccupied(gameBoard, helper.retrieveAvailableBoardSpace(gameBoard, userInput - 1)))
					|| helper.retrieveAvailableBoardSpace(gameBoard, userInput - 1) < 0);

			userInsertionPoint = helper.retrieveAvailableBoardSpace(gameBoard, userInput - 1);
			helper.insertInputIntoBoard(gameBoard, userInsertionPoint, userPlayingCharacter);

			if (validator.connectFour(gameBoard, userInsertionPoint) || validator.allGameBoardSpacesFilled(gameBoard)) {
				break;
			}

			do {
				cpuInput = generator.generateRandomInput();
			} while (helper.isSpaceAlreadyOccupied(gameBoard,
					helper.retrieveAvailableBoardSpace(gameBoard, cpuInput - 1))
					|| helper.retrieveAvailableBoardSpace(gameBoard, cpuInput - 1) < 0);

			cpuInsertionPoint = helper.retrieveAvailableBoardSpace(gameBoard, cpuInput - 1);
			helper.insertInputIntoBoard(gameBoard, cpuInsertionPoint, cpuPlayingCharacter);

			System.out.println();
			printer.printGameBoard(gameBoard);

		} while (!validator.connectFour(gameBoard, cpuInsertionPoint)
				&& !validator.allGameBoardSpacesFilled(gameBoard));

		System.out.println();
		printer.printGameBoard(gameBoard);

		final boolean playerWon = validator.connectFour(gameBoard, userInsertionPoint);
		final boolean cpuWon = validator.connectFour(gameBoard, cpuInsertionPoint);

		System.out.println();
		validator.handleResult(playerWon, cpuWon, gameBoard, userPlayingCharacter, cpuPlayingCharacter,
				userInsertionPoint, cpuInsertionPoint);

	}

}
