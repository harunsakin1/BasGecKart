package com.haruns.exception;

import lombok.Getter;

@Getter
public class TransportException extends RuntimeException{
	private ErrorType errorType;
	public TransportException(ErrorType errorType) {
		super(errorType.getMessage());
		this.errorType=errorType;
	}
}