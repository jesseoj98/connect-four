package com.jesseojones.connectfour.domain;

import java.util.List;

public class Result {

	private boolean cpuWon;

	private boolean playerWon;

	private List<Integer> winningSpaces;

	public Result(boolean cpuWon, boolean playerWon, List<Integer> winningSpaces) {
		this.cpuWon = cpuWon;
		this.playerWon = playerWon;
		this.winningSpaces = winningSpaces;
	}

}
