package com.jesseoj98.connectfour.domain;

import java.util.Objects;

/**
 * SpaceBounds class holds information relating to two maximum directions to
 * form a connect four string
 */
public final class SpaceBounds {

	/**
	 * The max above
	 */
	private final int maxAbove;

	/**
	 * The max below
	 */
	private final int maxBelow;

	/**
	 * Constructor to build the object
	 * 
	 * @param maxAbove the max above to set
	 * @param maxBelow the max below to set
	 */
	public SpaceBounds(int maxAbove, int maxBelow) {
		this.maxAbove = maxAbove;
		this.maxBelow = maxBelow;
	}

	/**
	 * Gets the max above
	 * 
	 * @return the max above
	 */
	public int getMaxAbove() {
		return maxAbove;
	}

	/**
	 * Gets the max below
	 * 
	 * @return the max below
	 */
	public int getMaxBelow() {
		return maxBelow;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maxAbove, maxBelow);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		SpaceBounds other = (SpaceBounds) obj;
		return maxAbove == other.maxAbove && maxBelow == other.maxBelow;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SpaceBounds [maxAbove=");
		builder.append(maxAbove);
		builder.append(", maxBelow=");
		builder.append(maxBelow);
		builder.append(']');
		return builder.toString();
	}

}
