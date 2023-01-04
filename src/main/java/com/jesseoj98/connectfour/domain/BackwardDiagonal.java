package com.jesseoj98.connectfour.domain;

import java.util.Objects;

public class BackwardDiagonal {

	private int space;

	private int maxAboveLeft;

	private int maxBelowRight;

	public BackwardDiagonal(int space, int maxAboveLeft, int maxBelowRight) {
		this.space = space;
		this.maxAboveLeft = maxAboveLeft;
		this.maxBelowRight = maxBelowRight;
	}

	public int getSpace() {
		return space;
	}

	public void setSpace(int space) {
		this.space = space;
	}

	public int getMaxAboveLeft() {
		return maxAboveLeft;
	}

	public void setMaxAboveLeft(int maxAboveLeft) {
		this.maxAboveLeft = maxAboveLeft;
	}

	public int getMaxBelowRight() {
		return maxBelowRight;
	}

	public void setMaxBelowRight(int maxBelowRight) {
		this.maxBelowRight = maxBelowRight;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maxAboveLeft, maxBelowRight, space);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		BackwardDiagonal other = (BackwardDiagonal) obj;
		return maxAboveLeft == other.maxAboveLeft && maxBelowRight == other.maxBelowRight && space == other.space;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BackwardDiagonal [space=");
		builder.append(space);
		builder.append(", maxAboveLeft=");
		builder.append(maxAboveLeft);
		builder.append(", maxBelowRight=");
		builder.append(maxBelowRight);
		builder.append(']');
		return builder.toString();
	}

}
