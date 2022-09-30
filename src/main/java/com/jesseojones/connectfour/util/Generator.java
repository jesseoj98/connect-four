package com.jesseojones.connectfour.util;

public class Generator {

	private static final int GAME_BOARD_Y_AXIS = 6;

	private static final int GAME_BOARD_X_AXIS = 7;

	private static final int GAME_BOARD_SPACES = 42;

	public char[] generateSimpleGameBoard() {
		return new char[GAME_BOARD_SPACES];
	}

	public char[][] generateComplexGameBoard() {
		final char[][] complexGameBoard = new char[GAME_BOARD_X_AXIS][];
		for (int i = 0; i < GAME_BOARD_X_AXIS; i++) {
			complexGameBoard[i] = new char[GAME_BOARD_Y_AXIS];
		}
		return complexGameBoard;
	}

}
