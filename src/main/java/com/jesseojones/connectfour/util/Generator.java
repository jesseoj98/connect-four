package com.jesseojones.connectfour.util;

import com.jesseojones.connectfour.domain.GameBoard;

public class Generator {

	public char[] generateGameBoard() {
		return new char[GameBoard.GAME_BOARD_SPACES];
	}

}
