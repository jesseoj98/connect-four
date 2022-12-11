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

	public boolean isCpuWon() {
		return cpuWon;
	}

	public void setCpuWon(boolean cpuWon) {
		this.cpuWon = cpuWon;
	}

	public boolean isPlayerWon() {
		return playerWon;
	}

	public void setPlayerWon(boolean playerWon) {
		this.playerWon = playerWon;
	}

	public List<Integer> getWinningSpaces() {
		return winningSpaces;
	}

	public void setWinningSpaces(List<Integer> winningSpaces) {
		this.winningSpaces = winningSpaces;
	}

}
