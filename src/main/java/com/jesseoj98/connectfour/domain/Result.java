package com.jesseoj98.connectfour.domain;

import java.util.List;
import java.util.Objects;

public final class Result {

	private final boolean cpuWon;

	private final boolean playerWon;

	private final List<List<Integer>> winningSpaces;

	public Result(boolean cpuWon, boolean playerWon, List<List<Integer>> winningSpaces) {
		this.cpuWon = cpuWon;
		this.playerWon = playerWon;
		this.winningSpaces = winningSpaces;
	}

	public boolean isCpuWon() {
		return cpuWon;
	}

	public boolean isPlayerWon() {
		return playerWon;
	}

	public List<List<Integer>> getWinningSpaces() {
		return winningSpaces;
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
