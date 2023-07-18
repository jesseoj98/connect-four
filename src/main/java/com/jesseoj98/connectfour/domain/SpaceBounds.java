package com.jesseoj98.connectfour.domain;

import java.util.Objects;

public final class SpaceBounds {

	private final int maxAbove;

	private final int maxBelow;

	public SpaceBounds(int maxAbove, int maxBelow) {
		this.maxAbove = maxAbove;
		this.maxBelow = maxBelow;
	}

	public int getMaxAbove() {
		return maxAbove;
	}

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
