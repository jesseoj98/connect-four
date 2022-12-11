package com.jesseojones.connectfour.util;

import com.jesseojones.connectfour.domain.GameBoard;

public class Helper {

	public boolean isSpaceAlreadyOccupied(char space) {
		return space == 'X' || space == 'O';
	}

	public boolean isSpaceAlreadyOccupied(char[] board, int space) {
		return isSpaceAlreadyOccupied(board[space]);
	}

	private void insertInputIntoBoard(char[] board, int space, char insert) {
		board[space] = insert;
	}

	public int insertIntoBoard(char[] board, int column, char insert) {
		int space = floorValue(column);
		if (!isSpaceAlreadyOccupied(board, space)) {
			insertInputIntoBoard(board, space, insert);
		} else {
			do {
				space = upOneRow(space);
				if (space < GameBoard.PREVIOUS_ROW && isSpaceAlreadyOccupied(board, space)) {
					break;
				}
			} while (!isSpaceAlreadyOccupied(board, space));
			if (isSpaceAlreadyOccupied(board, space)) {
				System.out.println("Cannot insert, column full!");
			} else {
				insertInputIntoBoard(board, space, insert);
			}
		}
		return space;
	}

	private int upOneRow(int value) {
		if (value < GameBoard.PREVIOUS_ROW) {
			return value;
		} else {
			return value - GameBoard.PREVIOUS_ROW;
		}
	}

	private int floorValue(int value) {
		return value + GameBoard.FLOOR;
	}

}
