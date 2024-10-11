package com.haruns.exception;

public class TransportException extends RuntimeException{
	private ErrorType errorType;
	public TransportException(ErrorType errorType) {
		super(errorType.getMessage());
		this.errorType=errorType;
	}
}