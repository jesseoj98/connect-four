package com.jesseoj98.connectfour.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import com.jesseoj98.connectfour.domain.BackwardDiagonal;
import com.jesseoj98.connectfour.domain.ForwardDiagonal;
import com.jesseoj98.connectfour.domain.GameBoard;

public class Generator {

	public char[] generateGameBoard() {
		return new char[GameBoard.GAME_BOARD_SPACES];
	}

	public int generateRandomInput() {
		return ThreadLocalRandom.current().nextInt(1, GameBoard.GAME_BOARD_X_AXIS + 1);
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
		invalidPositions.add(2);
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

	public Map<Integer, BackwardDiagonal> generateBackwardDiagonalInformation() {
		final Map<Integer, BackwardDiagonal> diagonals = new HashMap<>();
		diagonals.put(0, new BackwardDiagonal(0, 3));
		diagonals.put(1, new BackwardDiagonal(0, 3));
		diagonals.put(2, new BackwardDiagonal(0, 3));
		diagonals.put(3, new BackwardDiagonal(0, 3));
		diagonals.put(7, new BackwardDiagonal(0, 3));
		diagonals.put(8, new BackwardDiagonal(1, 3));
		diagonals.put(9, new BackwardDiagonal(1, 3));
		diagonals.put(10, new BackwardDiagonal(1, 3));
		diagonals.put(11, new BackwardDiagonal(1, 2));
		diagonals.put(14, new BackwardDiagonal(0, 3));
		diagonals.put(15, new BackwardDiagonal(1, 3));
		diagonals.put(16, new BackwardDiagonal(2, 3));
		diagonals.put(17, new BackwardDiagonal(2, 3));
		diagonals.put(18, new BackwardDiagonal(2, 2));
		diagonals.put(19, new BackwardDiagonal(2, 1));
		diagonals.put(22, new BackwardDiagonal(1, 2));
		diagonals.put(23, new BackwardDiagonal(2, 2));
		diagonals.put(24, new BackwardDiagonal(3, 2));
		diagonals.put(25, new BackwardDiagonal(3, 2));
		diagonals.put(26, new BackwardDiagonal(3, 1));
		diagonals.put(27, new BackwardDiagonal(3, 0));
		diagonals.put(30, new BackwardDiagonal(2, 1));
		diagonals.put(31, new BackwardDiagonal(3, 1));
		diagonals.put(32, new BackwardDiagonal(3, 1));
		diagonals.put(33, new BackwardDiagonal(3, 1));
		diagonals.put(34, new BackwardDiagonal(3, 0));
		diagonals.put(38, new BackwardDiagonal(3, 0));
		diagonals.put(39, new BackwardDiagonal(3, 0));
		diagonals.put(40, new BackwardDiagonal(3, 0));
		diagonals.put(41, new BackwardDiagonal(3, 0));
		return diagonals;
	}

	public Map<Integer, ForwardDiagonal> generateForwardDiagonalInformation() {
		final Map<Integer, ForwardDiagonal> diagonals = new HashMap<>();
		diagonals.put(3, new ForwardDiagonal(0, 3));
		diagonals.put(4, new ForwardDiagonal(0, 3));
		diagonals.put(5, new ForwardDiagonal(0, 3));
		diagonals.put(6, new ForwardDiagonal(0, 3));
		diagonals.put(9, new ForwardDiagonal(1, 2));
		diagonals.put(10, new ForwardDiagonal(1, 3));
		diagonals.put(11, new ForwardDiagonal(1, 3));
		diagonals.put(12, new ForwardDiagonal(1, 3));
		diagonals.put(13, new ForwardDiagonal(0, 3));
		diagonals.put(15, new ForwardDiagonal(2, 1));
		diagonals.put(16, new ForwardDiagonal(2, 3));
		diagonals.put(17, new ForwardDiagonal(2, 3));
		diagonals.put(18, new ForwardDiagonal(2, 3));
		diagonals.put(19, new ForwardDiagonal(1, 3));
		diagonals.put(20, new ForwardDiagonal(0, 3));
		diagonals.put(21, new ForwardDiagonal(3, 0));
		diagonals.put(22, new ForwardDiagonal(3, 1));
		diagonals.put(23, new ForwardDiagonal(3, 2));
		diagonals.put(24, new ForwardDiagonal(3, 2));
		diagonals.put(25, new ForwardDiagonal(2, 2));
		diagonals.put(26, new ForwardDiagonal(1, 2));
		diagonals.put(28, new ForwardDiagonal(0, 3));
		diagonals.put(29, new ForwardDiagonal(3, 1));
		diagonals.put(30, new ForwardDiagonal(3, 1));
		diagonals.put(31, new ForwardDiagonal(3, 1));
		diagonals.put(32, new ForwardDiagonal(2, 1));
		diagonals.put(35, new ForwardDiagonal(3, 0));
		diagonals.put(36, new ForwardDiagonal(3, 0));
		diagonals.put(37, new ForwardDiagonal(3, 0));
		diagonals.put(38, new ForwardDiagonal(3, 0));
		return diagonals;
	}

}
