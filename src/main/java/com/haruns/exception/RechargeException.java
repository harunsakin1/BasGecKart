package com.haruns.exception;

public class RechargeException extends RuntimeException{
	private ErrorType errorType;
	
	public RechargeException(ErrorType errorType) {
		super(errorType.getMessage());
		this.errorType = errorType;
	}
}