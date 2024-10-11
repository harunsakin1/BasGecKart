package com.haruns.exception;

import lombok.Getter;

@Getter
public class ExpenseException extends RuntimeException{
	private ErrorType errorType;

	public ExpenseException(ErrorType errorType) {
		super(errorType.getMessage());
		this.errorType = errorType;
	}
}