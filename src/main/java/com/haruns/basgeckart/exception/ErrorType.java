package com.haruns.basgeckart.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
	
	INTERNAL_SERVER_ERROR(500,"Sunucuda beklenmeyen bir hata meydana geldi. Lütfen tekrar deneyin",
	                      HttpStatus.INTERNAL_SERVER_ERROR),
	CARD_NOT_FOUND(5001,"Kayıtlı kart bulunamadı.",HttpStatus.BAD_REQUEST),
	TRANSPORT_NOT_FOUND(6001,"Kayıtlı toplu taşıma aracı bulunamadı.",HttpStatus.BAD_REQUEST),
	PASSENGER_NOT_FOUND(7001,"Kayıtlı yolcu bulunamadı.",HttpStatus.BAD_REQUEST);
	
	
	private int code;
	private String message;
	private HttpStatus httpStatus;
}