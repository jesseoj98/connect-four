package com.jesseoj98.connectfour;

import java.util.Scanner;

import com.jesseoj98.connectfour.util.Generator;
import com.jesseoj98.connectfour.util.Helper;
import com.jesseoj98.connectfour.util.Printer;
import com.jesseoj98.connectfour.util.Validator;

public class Game {

	private static final Generator generator = new Generator();
	private static final Helper helper = new Helper();
	private static final Printer printer = new Printer();
	private static final Scanner scanner = new Scanner(System.in);
	private static final Validator validator = new Validator();

	public void playGame() {

		char userInput;
		char userPlayingCharacter;
		boolean letCpuGoFirst;

		System.out.println("Connect Four by Jesse Jones\n");

		System.out.print("Choose X or O: ");

		do {
			userInput = scanner.next().charAt(0);
		} while (!validator.isInputPlayingCharacterValid(userInput));

		userPlayingCharacter = Character.toUpperCase(userInput);

		char cpuPlayingCharacter = userPlayingCharacter == 'X' ? 'O' : 'X';

		System.out.print("Let the CPU go first? (y/n): ");

		do {
			userInput = scanner.next().charAt(0);
		} while (!validator.isInputValid(userInput));

		letCpuGoFirst = validator.letCpuGoFirst(userInput);

		playGame(userPlayingCharacter, cpuPlayingCharacter, letCpuGoFirst);

		System.out.print("\nPlay again? (y/n): ");
	}

	private void playGame(char userPlayingCharacter, char cpuPlayingCharacter, boolean letCpuGoFirst) {

		int userInputSimple;
		int cpuInputSimple;

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
				userInputSimple = scanner.nextInt();
			} while (!validator.isInputValid(userInputSimple) && helper.isSpaceAlreadyOccupied(gameBoard,
					helper.retrieveAvailableBoardSpace(gameBoard, userInputSimple - 1)));

			helper.insertInputIntoBoard(gameBoard, helper.retrieveAvailableBoardSpace(gameBoard, userInputSimple - 1),
					userPlayingCharacter);

			if (validator.connectFour(gameBoard, userPlayingCharacter)
					|| validator.allGameBoardSpacesFilled(gameBoard)) {
				break;
			}

			do {
				cpuInputSimple = generator.generateRandomInput();
			} while (helper.isSpaceAlreadyOccupied(gameBoard,
					helper.retrieveAvailableBoardSpace(gameBoard, cpuInputSimple - 1)));

			helper.insertInputIntoBoard(gameBoard, helper.retrieveAvailableBoardSpace(gameBoard, cpuInputSimple - 1),
					cpuPlayingCharacter);

			System.out.println();
			printer.printGameBoard(gameBoard);

		} while (!validator.connectFour(gameBoard, cpuPlayingCharacter)
				&& !validator.allGameBoardSpacesFilled(gameBoard));

		// to-do: handle the result of the game
//		System.out.println();
//		printer.printGameBoard(gameBoard);
//
//		final boolean playerWon = validator.connectFour(gameBoard, userPlayingCharacter);
//		final boolean cpuWon = validator.connectFour(gameBoard, cpuPlayingCharacter);
//
//		System.out.println();
//		validator.handleResult(playerWon, cpuWon, gameBoard, userPlayingCharacter, cpuPlayingCharacter);

	}

}
