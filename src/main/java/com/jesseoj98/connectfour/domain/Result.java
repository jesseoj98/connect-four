package com.jesseoj98.connectfour.domain;

import java.util.List;
import java.util.Objects;

/**
 * Result class stores information about the result of the game
 */
public class Result {

	/**
	 * Whether the cpu won
	 */
	private boolean cpuWon;

	/**
	 * Whether the player won
	 */
	private boolean playerWon;

	/**
	 * The winning spaces
	 */
	private List<Integer> winningSpaces;

	/**
	 * Constructor to build the object
	 * 
	 * @param cpuWon        the cpu won to set
	 * @param playerWon     the player won to set
	 * @param winningSpaces the winning spaces to set
	 */
	public Result(boolean cpuWon, boolean playerWon, List<Integer> winningSpaces) {
		this.cpuWon = cpuWon;
		this.playerWon = playerWon;
		this.winningSpaces = winningSpaces;
	}

	/**
	 * Gets the cpu won
	 * 
	 * @return if the cpu won
	 */
	public boolean isCpuWon() {
		return cpuWon;
	}

	/**
	 * Sets the cpu won
	 * 
	 * @param cpuWon the cpu won to set
	 */
	public void setCpuWon(boolean cpuWon) {
		this.cpuWon = cpuWon;
	}

	/**
	 * Gets the player won
	 * 
	 * @return if the player won
	 */
	public boolean isPlayerWon() {
		return playerWon;
	}

	/**
	 * Sets the player won
	 * 
	 * @param playerWon the player won to set
	 */
	public void setPlayerWon(boolean playerWon) {
		this.playerWon = playerWon;
	}

	/**
	 * Gets the winning spaces
	 * 
	 * @return the winning spaces
	 */
	public List<Integer> getWinningSpaces() {
		return winningSpaces;
	}

	/**
	 * Sets the winning spaces
	 * 
	 * @param winningSpaces the winning spaces to set
	 */
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
