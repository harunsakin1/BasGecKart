package com.haruns.basgeckart.exception;

import lombok.Getter;

@Getter
public class PassengerException extends RuntimeException{
	private ErrorType errorType;
	
	public PassengerException(ErrorType errorType) {
		super(errorType.getMessage());
		this.errorType=errorType;
		System.out.println("PASSENGER EXCEPTION CONST.");
	}
}