package com.haruns.exception;

import lombok.Getter;

@Getter
public class PassengerException extends RuntimeException{
	private ErrorType errorType;
	public PassengerException(ErrorType errorType) {
		super(errorType.getMessage());
		this.errorType=errorType;
	}
}