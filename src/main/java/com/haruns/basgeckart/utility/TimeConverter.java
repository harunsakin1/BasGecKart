package com.haruns.basgeckart.utility;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeConverter {
	//iki ms arası dk farkını hesaplama
	
	//msyi localdateTime'a çeviren metot
	
	//msyi localdate'e çeviren metot
	
	public static Long epochToMinute(Long startTime ,Long endTime){
		Long difference = endTime - startTime;
		return difference / 60000;
	}
	
	public static LocalDateTime epochToDateTime(Long epochTime){
		LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(epochTime), ZoneId.systemDefault());
		return localDateTime;
	}
	
	public static LocalDate epochToLocalDate(Long epochTime){
		LocalDate localDate = LocalDate.ofInstant(Instant.ofEpochMilli(epochTime), ZoneId.systemDefault());
		return localDate;
	}
	
}