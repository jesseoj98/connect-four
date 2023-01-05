package com.jesseoj98.connectfour;

import java.util.Scanner;

import com.jesseoj98.connectfour.util.Validator;

public class ConnectFour {

	private static final Game game = new Game();
	private static final Scanner scanner = new Scanner(System.in);
	private static final Validator validator = new Validator();

	public static void main(String[] args) {

		char playAgain;

		do {

			game.playGame();

			do {
				playAgain = scanner.next().charAt(0);
			} while (!validator.isInputValid(playAgain));

			System.out.println();

		} while (validator.playAgain(playAgain));

		System.out.println("Thanks for playing!");
	}

}
