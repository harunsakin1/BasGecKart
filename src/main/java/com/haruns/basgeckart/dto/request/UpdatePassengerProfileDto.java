package com.haruns.basgeckart.dto.request;

import java.time.LocalDate;

public record UpdatePassengerProfileDto(
		Long id,
		String name,
		String surname,
		String tc,
		LocalDate birthDate,
		String phone,
		String email,
		String avatar,
		String address
) {
}