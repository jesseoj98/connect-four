package com.jesseoj98.connectfour.domain;

import java.util.Objects;

public class ForwardDiagonal {

	private int maxAboveRight;

	private int maxBelowLeft;

	public ForwardDiagonal(int maxAboveRight, int maxBelowLeft) {
		this.maxAboveRight = maxAboveRight;
		this.maxBelowLeft = maxBelowLeft;
	}

	public int getMaxAboveRight() {
		return maxAboveRight;
	}

	public void setMaxAboveRight(int maxAboveRight) {
		this.maxAboveRight = maxAboveRight;
	}

	public int getMaxBelowLeft() {
		return maxBelowLeft;
	}

	public void setMaxBelowLeft(int maxBelowLeft) {
		this.maxBelowLeft = maxBelowLeft;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maxAboveRight, maxBelowLeft);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		ForwardDiagonal other = (ForwardDiagonal) obj;
		return maxAboveRight == other.maxAboveRight && maxBelowLeft == other.maxBelowLeft;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ForwardDiagonal [maxAboveRight=");
		builder.append(maxAboveRight);
		builder.append(", maxBelowLeft=");
		builder.append(maxBelowLeft);
		builder.append(']');
		return builder.toString();
	}

}
