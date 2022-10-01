package com.jesseojones.connectfour.util;

public class Validator {

	private static final int BESIDE = 1;

	private static final int FORWARD_DIAGONAL = 6;

	private static final int LEVEL = 7;

	private static final int BACKWARD_DIAGONAL = 8;

	private int retrieveTopAdjacentSpace(int value) {
		return value + LEVEL;
	}

	private int retrieveRightAdjacentSpace(int value) {
		return value + BESIDE;
	}

	private int retrieveBottomAdjacentSpace(int value) {
		return value - LEVEL;
	}

	private int retrieveLeftAdjacentSpace(int value) {
		return value - BESIDE;
	}

	private int retrieveTopLeftAdjacentSpace(int value) {
		return value - BACKWARD_DIAGONAL;
	}

	private int retrieveTopRightAdjacentSpace(int value) {
		return value - FORWARD_DIAGONAL;
	}

	private int retrieveBottomRightAdjacentSpace(int value) {
		return value + BACKWARD_DIAGONAL;
	}

	private int retrieveBottomLeftAdjacentSpace(int value) {
		return value + FORWARD_DIAGONAL;
	}

	private boolean valueMatch(char insert, char adjacentValue) {
		return insert == adjacentValue;
	}

}
