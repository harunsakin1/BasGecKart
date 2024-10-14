package com.haruns.basgeckart.exception;

import lombok.Getter;

@Getter
public class CardException extends RuntimeException {
	private ErrorType errorType;
	public CardException(ErrorType errorType){
		super(errorType.getMessage());
		this.errorType = errorType;
	}
}