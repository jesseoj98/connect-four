package com.jesseojones.connectfour.domain;

import java.util.List;

public class Results {

	private boolean cpuWon;

	private boolean playerWon;

	private List<Integer> winningSpaces;

	public Results(boolean cpuWon, boolean playerWon, List<Integer> winningSpaces) {
		this.cpuWon = cpuWon;
		this.playerWon = playerWon;
		this.winningSpaces = winningSpaces;
	}

}
