package com.jesseojones.connectfour.util;

import com.jesseojones.connectfour.domain.GameBoard;

public class Generator {

	public char[] generateSimpleGameBoard() {
		return new char[GameBoard.GAME_BOARD_SPACES];
	}

	public char[][] generateComplexGameBoard() {
		final char[][] complexGameBoard = new char[GameBoard.GAME_BOARD_X_AXIS][];
		for (int i = 0; i < GameBoard.GAME_BOARD_X_AXIS; i++) {
			complexGameBoard[i] = new char[GameBoard.GAME_BOARD_Y_AXIS];
		}
		return complexGameBoard;
	}

}
