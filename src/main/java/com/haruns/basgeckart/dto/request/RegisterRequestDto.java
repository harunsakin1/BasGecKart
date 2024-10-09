package com.haruns.basgeckart.dto.request;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data

public class RegisterRequestDto {
	@NotNull
	//TODO @NotBlank ile dene
	String name;
	@NotNull
	String surname;
	@NotNull
	@Pattern(message = "TC sadece rakam içerebilir ve 11 haneli olmalıdır", regexp = "^\\d{11}$")
	String tc;
	@NotNull
	LocalDate birthDate;
	@NotNull
	String address;
	
}