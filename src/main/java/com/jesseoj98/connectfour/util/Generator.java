package com.jesseoj98.connectfour.util;

import java.util.ArrayList;
import java.util.List;

import com.jesseoj98.connectfour.domain.GameBoard;

public class Generator {

	public char[] generateGameBoard() {
		return new char[GameBoard.GAME_BOARD_SPACES];
	}

	public List<Integer> generateInvalidBackwardDiagonalPositions() {
		final List<Integer> invalidPositions = new ArrayList<>();
		invalidPositions.add(4);
		invalidPositions.add(5);
		invalidPositions.add(6);
		invalidPositions.add(12);
		invalidPositions.add(13);
		invalidPositions.add(20);
		invalidPositions.add(21);
		invalidPositions.add(28);
		invalidPositions.add(29);
		invalidPositions.add(35);
		invalidPositions.add(36);
		invalidPositions.add(37);
		return invalidPositions;
	}

	public List<Integer> generateInvalidForwardDiagonalPositions() {
		final List<Integer> invalidPositions = new ArrayList<>();
		invalidPositions.add(0);
		invalidPositions.add(1);
		invalidPositions.add(7);
		invalidPositions.add(8);
		invalidPositions.add(14);
		invalidPositions.add(27);
		invalidPositions.add(33);
		invalidPositions.add(34);
		invalidPositions.add(39);
		invalidPositions.add(40);
		invalidPositions.add(41);
		return invalidPositions;
	}

}
