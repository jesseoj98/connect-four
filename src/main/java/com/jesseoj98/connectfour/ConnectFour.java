package com.jesseoj98.connectfour;

import java.util.Scanner;

/**
 * ConnectFour class contains main method to play the game
 */
public class ConnectFour {

	/** Instantiation of classes */
	private static final Game game = new Game();
	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * Main method
	 * 
	 * @param args the string args
	 */
	public static void main(String[] args) {

		char playAgain;

		do {

			game.playGame();

			do {
				playAgain = scanner.next().charAt(0);
			} while (!(playAgain == 'y' || playAgain == 'Y' || playAgain == 'n' || playAgain == 'N'));

			System.out.println();

		} while (playAgain == 'y' || playAgain == 'Y');

		System.out.println("Thanks for playing!");
	}

}
