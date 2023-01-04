package com.jesseoj98.connectfour.domain;

import java.util.Objects;

public class BackwardDiagonal {

	private int maxAboveLeft;

	private int maxBelowRight;

	public BackwardDiagonal(int maxAboveLeft, int maxBelowRight) {
		this.maxAboveLeft = maxAboveLeft;
		this.maxBelowRight = maxBelowRight;
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
		return Objects.hash(maxAboveLeft, maxBelowRight);
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
		return maxAboveLeft == other.maxAboveLeft && maxBelowRight == other.maxBelowRight;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BackwardDiagonal [maxAboveLeft=");
		builder.append(maxAboveLeft);
		builder.append(", maxBelowRight=");
		builder.append(maxBelowRight);
		builder.append(']');
		return builder.toString();
	}

}
