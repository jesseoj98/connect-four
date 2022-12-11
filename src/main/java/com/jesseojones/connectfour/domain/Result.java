package com.jesseojones.connectfour.domain;

import java.util.List;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(cpuWon, playerWon, winningSpaces);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Result other = (Result) obj;
		return cpuWon == other.cpuWon && playerWon == other.playerWon
				&& Objects.equals(winningSpaces, other.winningSpaces);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Result [cpuWon=");
		builder.append(cpuWon);
		builder.append(", playerWon=");
		builder.append(playerWon);
		builder.append(", winningSpaces=");
		builder.append(winningSpaces);
		builder.append(']');
		return builder.toString();
	}

}
