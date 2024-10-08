package com.haruns.basgeckart.utility.enums;

public enum TransportType {
	BUS(10),
	METRO(15),
	TRAM(8),
	FERRY(50);
	
	private double price;
	
	TransportType(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
}