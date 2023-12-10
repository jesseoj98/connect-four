package com.jesseoj98.connectfour.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import com.jesseoj98.connectfour.domain.GameBoard;
import com.jesseoj98.connectfour.domain.SpaceBounds;

public class Generator {

	public char[] generateGameBoard() {
		return new char[GameBoard.GAME_BOARD_SPACES];
	}

	public int generateRandomInput() {
		return ThreadLocalRandom.current().nextInt(1, GameBoard.GAME_BOARD_X_AXIS + 1);
	}

	public Set<Integer> generateInvalidBackwardDiagonalPositions() {
		final Set<Integer> invalidPositions = new HashSet<>();
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

	public Set<Integer> generateInvalidForwardDiagonalPositions() {
		final Set<Integer> invalidPositions = new HashSet<>();
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

	public Map<Integer, SpaceBounds> generateVerticalInformation() {
		final Map<Integer, SpaceBounds> verticals = new HashMap<>();
		verticals.put(0, new SpaceBounds(0, 3));
		verticals.put(1, new SpaceBounds(0, 3));
		verticals.put(2, new SpaceBounds(0, 3));
		verticals.put(3, new SpaceBounds(0, 3));
		verticals.put(4, new SpaceBounds(0, 3));
		verticals.put(5, new SpaceBounds(0, 3));
		verticals.put(6, new SpaceBounds(0, 3));
		verticals.put(7, new SpaceBounds(1, 3));
		verticals.put(8, new SpaceBounds(1, 3));
		verticals.put(9, new SpaceBounds(1, 3));
		verticals.put(10, new SpaceBounds(1, 3));
		verticals.put(11, new SpaceBounds(1, 3));
		verticals.put(12, new SpaceBounds(1, 3));
		verticals.put(13, new SpaceBounds(1, 3));
		verticals.put(14, new SpaceBounds(2, 3));
		verticals.put(15, new SpaceBounds(2, 3));
		verticals.put(16, new SpaceBounds(2, 3));
		verticals.put(17, new SpaceBounds(2, 3));
		verticals.put(18, new SpaceBounds(2, 3));
		verticals.put(19, new SpaceBounds(2, 3));
		verticals.put(20, new SpaceBounds(2, 3));
		return verticals;
	}

	public Map<Integer, SpaceBounds> generateHorizontalInformation() {
		final Map<Integer, SpaceBounds> horizontals = new HashMap<>();
		horizontals.put(0, new SpaceBounds(0, 3));
		horizontals.put(1, new SpaceBounds(1, 3));
		horizontals.put(2, new SpaceBounds(2, 3));
		horizontals.put(3, new SpaceBounds(3, 3));
		horizontals.put(4, new SpaceBounds(3, 2));
		horizontals.put(5, new SpaceBounds(3, 1));
		horizontals.put(6, new SpaceBounds(3, 0));
		horizontals.put(7, new SpaceBounds(0, 3));
		horizontals.put(8, new SpaceBounds(1, 3));
		horizontals.put(9, new SpaceBounds(2, 3));
		horizontals.put(10, new SpaceBounds(3, 3));
		horizontals.put(11, new SpaceBounds(3, 2));
		horizontals.put(12, new SpaceBounds(3, 1));
		horizontals.put(13, new SpaceBounds(3, 0));
		horizontals.put(14, new SpaceBounds(0, 3));
		horizontals.put(15, new SpaceBounds(1, 3));
		horizontals.put(16, new SpaceBounds(2, 3));
		horizontals.put(17, new SpaceBounds(3, 3));
		horizontals.put(18, new SpaceBounds(3, 2));
		horizontals.put(19, new SpaceBounds(3, 1));
		horizontals.put(20, new SpaceBounds(3, 0));
		horizontals.put(21, new SpaceBounds(0, 3));
		horizontals.put(22, new SpaceBounds(1, 3));
		horizontals.put(23, new SpaceBounds(2, 3));
		horizontals.put(24, new SpaceBounds(3, 3));
		horizontals.put(25, new SpaceBounds(3, 2));
		horizontals.put(26, new SpaceBounds(3, 1));
		horizontals.put(27, new SpaceBounds(3, 0));
		horizontals.put(28, new SpaceBounds(0, 3));
		horizontals.put(29, new SpaceBounds(1, 3));
		horizontals.put(30, new SpaceBounds(2, 3));
		horizontals.put(31, new SpaceBounds(3, 3));
		horizontals.put(32, new SpaceBounds(3, 2));
		horizontals.put(33, new SpaceBounds(3, 1));
		horizontals.put(34, new SpaceBounds(3, 0));
		horizontals.put(35, new SpaceBounds(0, 3));
		horizontals.put(36, new SpaceBounds(1, 3));
		horizontals.put(37, new SpaceBounds(2, 3));
		horizontals.put(38, new SpaceBounds(3, 3));
		horizontals.put(39, new SpaceBounds(3, 2));
		horizontals.put(40, new SpaceBounds(3, 1));
		horizontals.put(41, new SpaceBounds(3, 0));
		return horizontals;
	}

	public Map<Integer, SpaceBounds> generateBackwardDiagonalInformation() {
		final Map<Integer, SpaceBounds> diagonals = new HashMap<>();
		diagonals.put(0, new SpaceBounds(0, 3));
		diagonals.put(1, new SpaceBounds(0, 3));
		diagonals.put(2, new SpaceBounds(0, 3));
		diagonals.put(3, new SpaceBounds(0, 3));
		diagonals.put(7, new SpaceBounds(0, 3));
		diagonals.put(8, new SpaceBounds(1, 3));
		diagonals.put(9, new SpaceBounds(1, 3));
		diagonals.put(10, new SpaceBounds(1, 3));
		diagonals.put(11, new SpaceBounds(1, 2));
		diagonals.put(14, new SpaceBounds(0, 3));
		diagonals.put(15, new SpaceBounds(1, 3));
		diagonals.put(16, new SpaceBounds(2, 3));
		diagonals.put(17, new SpaceBounds(2, 3));
		diagonals.put(18, new SpaceBounds(2, 2));
		diagonals.put(19, new SpaceBounds(2, 1));
		diagonals.put(22, new SpaceBounds(1, 2));
		diagonals.put(23, new SpaceBounds(2, 2));
		diagonals.put(24, new SpaceBounds(3, 2));
		diagonals.put(25, new SpaceBounds(3, 2));
		diagonals.put(26, new SpaceBounds(3, 1));
		diagonals.put(27, new SpaceBounds(3, 0));
		diagonals.put(30, new SpaceBounds(2, 1));
		diagonals.put(31, new SpaceBounds(3, 1));
		diagonals.put(32, new SpaceBounds(3, 1));
		diagonals.put(33, new SpaceBounds(3, 1));
		diagonals.put(34, new SpaceBounds(3, 0));
		diagonals.put(38, new SpaceBounds(3, 0));
		diagonals.put(39, new SpaceBounds(3, 0));
		diagonals.put(40, new SpaceBounds(3, 0));
		diagonals.put(41, new SpaceBounds(3, 0));
		return diagonals;
	}

	public Map<Integer, SpaceBounds> generateForwardDiagonalInformation() {
		final Map<Integer, SpaceBounds> diagonals = new HashMap<>();
		diagonals.put(3, new SpaceBounds(0, 3));
		diagonals.put(4, new SpaceBounds(0, 3));
		diagonals.put(5, new SpaceBounds(0, 3));
		diagonals.put(6, new SpaceBounds(0, 3));
		diagonals.put(9, new SpaceBounds(1, 2));
		diagonals.put(10, new SpaceBounds(1, 3));
		diagonals.put(11, new SpaceBounds(1, 3));
		diagonals.put(12, new SpaceBounds(1, 3));
		diagonals.put(13, new SpaceBounds(0, 3));
		diagonals.put(15, new SpaceBounds(2, 1));
		diagonals.put(16, new SpaceBounds(2, 2));
		diagonals.put(17, new SpaceBounds(2, 3));
		diagonals.put(18, new SpaceBounds(2, 3));
		diagonals.put(19, new SpaceBounds(1, 3));
		diagonals.put(20, new SpaceBounds(0, 3));
		diagonals.put(21, new SpaceBounds(3, 0));
		diagonals.put(22, new SpaceBounds(3, 1));
		diagonals.put(23, new SpaceBounds(3, 2));
		diagonals.put(24, new SpaceBounds(3, 2));
		diagonals.put(25, new SpaceBounds(2, 2));
		diagonals.put(26, new SpaceBounds(1, 2));
		diagonals.put(28, new SpaceBounds(0, 3));
		diagonals.put(29, new SpaceBounds(3, 1));
		diagonals.put(30, new SpaceBounds(3, 1));
		diagonals.put(31, new SpaceBounds(3, 1));
		diagonals.put(32, new SpaceBounds(2, 1));
		diagonals.put(35, new SpaceBounds(3, 0));
		diagonals.put(36, new SpaceBounds(3, 0));
		diagonals.put(37, new SpaceBounds(3, 0));
		diagonals.put(38, new SpaceBounds(3, 0));
		return diagonals;
	}

}
