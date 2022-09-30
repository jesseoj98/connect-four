package com.jesseojones.connectfour.util;

public class Printer {

	private static final int GAME_BOARD_X_AXIS = 7;

	private static final int GAME_BOARD_SPACES = 42;

	private static Helper helper = new Helper();

	public void printSimpleGameBoard(char[] board) {
		printGameBoardInsertNumbers();
		printGameBoardDivider();
		for (int i = 0; i < GAME_BOARD_SPACES; i++) {
			if ((i + 1) % GAME_BOARD_X_AXIS == 0) {
				System.out.println("|" + printGameBoardSpace(board[i]) + "|");
				printGameBoardDivider();
			} else {
				System.out.print("|" + printGameBoardSpace(board[i]));
			}
		}
	}

	private void printGameBoardInsertNumbers() {
		System.out.println("  1   2   3   4   5   6   7  ");
	}

	private void printGameBoardInsertNumbersLoop() {
		System.out.print("  ");
		for (int i = 0; i < GAME_BOARD_X_AXIS; i++) {
			if (i != GAME_BOARD_X_AXIS - 1) {
				System.out.print((i + 1) + "   ");
			} else {
				System.out.print((i + 1) + "  ");
			}
		}
		System.out.println();
	}

	private void printGameBoardDivider() {
		System.out.println("|---|---|---|---|---|---|---|");
	}

	private String printGameBoardSpace(char space) {
		if (helper.isSpaceAlreadyOccupied(space)) {
			return " " + Character.toString(space) + " ";
		} else {
			return "   ";
		}
	}

}
