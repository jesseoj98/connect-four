package com.jesseoj98.connectfour.domain;

import java.util.Objects;

public class SpaceBounds {

	private int maxAbove;

	private int maxBelow;

	public SpaceBounds(int maxAbove, int maxBelow) {
		this.maxAbove = maxAbove;
		this.maxBelow = maxBelow;
	}

	public int getMaxAbove() {
		return maxAbove;
	}

	public void setMaxAbove(int maxAbove) {
		this.maxAbove = maxAbove;
	}

	public int getMaxBelow() {
		return maxBelow;
	}

	public void setMaxBelow(int maxBelow) {
		this.maxBelow = maxBelow;
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
		builder.append("SpaceBound [maxAbove=");
		builder.append(maxAbove);
		builder.append(", maxBelow=");
		builder.append(maxBelow);
		builder.append(']');
		return builder.toString();
	}

}
