package com.haruns.basgeckart.utility.enums;

public enum CardType {
	STANDARD(1),
	STUDENT(0.5),
	TEACHER(0.7),
	HANDICAPPED(0),
	ELDER(0);
	
	private double discountRate;
	
	CardType(double discountRate) {
		this.discountRate = discountRate;
	}
	
	public double getDiscountRate() {
		return discountRate;
	}
}