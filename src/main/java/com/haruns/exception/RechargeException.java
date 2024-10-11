package com.haruns.exception;

import lombok.Getter;

@Getter
public class RechargeException extends RuntimeException{
	private ErrorType errorType;
	
	public RechargeException(ErrorType errorType) {
		super(errorType.getMessage());
		this.errorType = errorType;
	}
}