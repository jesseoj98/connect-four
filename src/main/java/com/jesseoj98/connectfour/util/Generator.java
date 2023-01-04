package com.jesseoj98.connectfour.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public Map<Integer, Integer> generateBackwardDiagonalBottomToTopDirections() {
		final Map<Integer, Integer> directions = new HashMap<>();
		directions.put(38, 3);
		directions.put(39, 3);
		directions.put(40, 3);
		directions.put(41, 3);
		directions.put(30, 2);
		directions.put(31, 2);
		directions.put(32, 2);
		directions.put(33, 2);
		directions.put(34, 2);
		directions.put(22, 1);
		directions.put(23, 1);
		directions.put(24, 1);
		directions.put(25, 1);
		directions.put(26, 1);
		directions.put(27, 1);
		directions.put(14, -1);
		directions.put(15, -1);
		directions.put(16, -1);
		directions.put(17, -1);
		directions.put(18, -1);
		directions.put(19, -1);
		directions.put(7, -2);
		directions.put(8, -2);
		directions.put(9, -2);
		directions.put(10, -2);
		directions.put(11, -2);
		directions.put(0, -3);
		directions.put(1, -3);
		directions.put(2, -3);
		directions.put(3, -3);
		return directions;
	}

	public Map<Integer, Integer> generateBackwardDiagonalTopToBottomDirections() {
		final Map<Integer, Integer> directions = new HashMap<>();
		directions.put(38, -3);
		directions.put(39, -3);
		directions.put(40, -3);
		directions.put(41, -3);
		directions.put(30, -2);
		directions.put(31, -2);
		directions.put(32, -2);
		directions.put(33, -2);
		directions.put(34, -2);
		directions.put(22, -1);
		directions.put(23, -1);
		directions.put(24, -1);
		directions.put(25, -1);
		directions.put(26, -1);
		directions.put(27, -1);
		directions.put(14, 1);
		directions.put(15, 1);
		directions.put(16, 1);
		directions.put(17, 1);
		directions.put(18, 1);
		directions.put(19, 1);
		directions.put(7, 2);
		directions.put(8, 2);
		directions.put(9, 2);
		directions.put(10, 2);
		directions.put(11, 2);
		directions.put(0, 3);
		directions.put(1, 3);
		directions.put(2, 3);
		directions.put(3, 3);
		return directions;
	}

	public Map<Integer, Integer> generateForwardDiagonalBottomToTopDirections() {
		final Map<Integer, Integer> directions = new HashMap<>();
		directions.put(35, 3);
		directions.put(36, 3);
		directions.put(37, 3);
		directions.put(38, 3);
		directions.put(28, 2);
		directions.put(29, 2);
		directions.put(30, 2);
		directions.put(31, 2);
		directions.put(32, 2);
		directions.put(21, 1);
		directions.put(22, 1);
		directions.put(23, 1);
		directions.put(24, 1);
		directions.put(25, 1);
		directions.put(26, 1);
		directions.put(15, -1);
		directions.put(16, -1);
		directions.put(17, -1);
		directions.put(18, -1);
		directions.put(19, -1);
		directions.put(20, -1);
		directions.put(9, -2);
		directions.put(10, -2);
		directions.put(11, -2);
		directions.put(12, -2);
		directions.put(13, -2);
		directions.put(3, -3);
		directions.put(4, -3);
		directions.put(5, -3);
		directions.put(6, -3);
		return directions;
	}

	public Map<Integer, Integer> generateForwardDiagonalTopToBottomDirections() {
		final Map<Integer, Integer> directions = new HashMap<>();
		directions.put(35, -3);
		directions.put(36, -3);
		directions.put(37, -3);
		directions.put(38, -3);
		directions.put(28, -2);
		directions.put(29, -2);
		directions.put(30, -2);
		directions.put(31, -2);
		directions.put(32, -2);
		directions.put(21, -1);
		directions.put(22, -1);
		directions.put(23, -1);
		directions.put(24, -1);
		directions.put(25, -1);
		directions.put(26, -1);
		directions.put(15, 1);
		directions.put(16, 1);
		directions.put(17, 1);
		directions.put(18, 1);
		directions.put(19, 1);
		directions.put(20, 1);
		directions.put(9, 2);
		directions.put(10, 2);
		directions.put(11, 2);
		directions.put(12, 2);
		directions.put(13, 2);
		directions.put(3, 3);
		directions.put(4, 3);
		directions.put(5, 3);
		directions.put(6, 3);
		return directions;
	}

}
