package com.haruns.basgeckart.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public ResponseEntity<ErrorMessage> runtimeExceptionHandler(RuntimeException exception){
		return createResponseEntity(ErrorType.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR,null);
	}
	
	@ExceptionHandler(PassengerException.class)
	@ResponseBody
	public ResponseEntity<ErrorMessage> passengerExceptionHandler(PassengerException exception){
		System.out.println("GLOBAL EXCEPTION");
		return createResponseEntity(exception.getErrorType(),exception.getErrorType().getHttpStatus(),null );
	}
	
	@ExceptionHandler(CardException.class)
	@ResponseBody
	public ResponseEntity<ErrorMessage> cardExceptionHandler(CardException exception){
		return createResponseEntity(exception.getErrorType(),exception.getErrorType().getHttpStatus(),null);
	}
	
	
	
	public ResponseEntity<ErrorMessage> createResponseEntity(ErrorType errorType,HttpStatus httpStatus,
	                                                         List<String> fields){
		log.error("TÜM HATALARIN GEÇTİĞİ NOKTA...: "+errorType.getMessage()+fields);
		return new ResponseEntity<>(ErrorMessage.builder()
		                                        .fields(fields)
		                                        .success(false)
		                                        .message(errorType.getMessage())
		                                        .code(errorType.getCode())
		                                        .build(),httpStatus);
	}
	

}