package com.haruns.basgeckart.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record RegisterRequestDto(
		@NotBlank
		String name,
		@NotBlank
		String surname,
		@NotBlank
		@Pattern(message = "TC sadece rakam içerebilir ve 11 haneli olmalıdır",
				regexp = "^\\d{11}$")
		String tc,
		@NotNull
		LocalDate birthDate,
		@NotBlank
		String address
) {
}