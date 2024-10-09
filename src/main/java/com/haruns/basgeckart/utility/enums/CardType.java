package com.haruns.basgeckart.utility.enums;

import java.time.LocalDate;


public enum CardType {
	STANDARD(1,LocalDate.now().plusYears(99)),
	STUDENT(0.5,LocalDate.now().plusYears(1)),
	TEACHER(0.7,LocalDate.now().plusYears(2)),
	HANDICAPPED(0,LocalDate.now().plusYears(2)),
	ELDER(0,LocalDate.now().plusYears(2));
	
	private double discountRate;
	private LocalDate visaDate;
	
	CardType(double discountRate,LocalDate visaDate) {
		this.discountRate = discountRate;
		this.visaDate=visaDate;
	}
	
	public double getDiscountRate() {
		return discountRate;
	}
	
	public LocalDate getVisaDate() {
		return visaDate;
	}
}