package com.jesseoj98.connectfour.util;

import java.util.List;

import com.jesseoj98.connectfour.domain.GameBoard;
import com.jesseoj98.connectfour.domain.Result;

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

	public void printResult(Result result) {
		if (result.isPlayerWon()) {
			System.out.print("Congratulations! You won with positions ");
		} else {
			System.out.print("Too bad! Cpu won with positions ");
		}
		System.out.print(printPositions(result.getWinningSpaces()));
	}

	private String printPositions(List<List<Integer>> positions) {
		final StringBuilder spots = new StringBuilder();
		for (int i = 0; i < positions.size(); i++) {
			for (int j = 0; j < positions.get(i).size(); j++) {
				if (j != positions.get(i).size() - 1) {
					spots.append(Integer.toString(positions.get(i).get(j) + 1) + ", ");
				} else {
					spots.append(Integer.toString(positions.get(i).get(j) + 1));
				}
			}
		}
		return spots.toString();
	}

}
