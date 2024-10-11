package com.haruns.exception;

public class CardException extends RuntimeException {
	private ErrorType errorType;
	public CardException(ErrorType errorType){
		super(errorType.getMessage());
		this.errorType = errorType;
	}
}