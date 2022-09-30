package com.jesseojones.connectfour.util;

public class Generator {

	private static final int GAME_BOARD_Y_AXIS = 6;

	private static final int GAME_BOARD_X_AXIS = 7;

	private static final int GAME_BOARD_SPACES = 42;

	public char[] generateSimpleGameBoard() {
		return new char[GAME_BOARD_SPACES];
	}

	public char[][] generateComplexGameBoard() {
		return new char[GAME_BOARD_X_AXIS][GAME_BOARD_Y_AXIS];
	}

}
