package com.jesseoj98.connectfour.util;

import com.jesseoj98.connectfour.domain.GameBoard;

public class Printer {

	private static Helper helper = new Helper();

	public void printGameBoard(char[] board) {
		printGameBoardInsertNumbers();
		printGameBoardDivider();
		for (int i = 0; i < GameBoard.GAME_BOARD_SPACES; i++) {
			if ((i + 1) % GameBoard.GAME_BOARD_X_AXIS == 0) {
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
