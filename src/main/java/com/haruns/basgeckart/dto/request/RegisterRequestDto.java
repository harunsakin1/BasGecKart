package com.haruns.basgeckart.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RegisterRequestDto {
	
	@NotBlank
	String name;
	@NotBlank
	String surname;
	@NotBlank
	@Pattern(message = "TC sadece rakam içerebilir ve 11 haneli olmalıdır", regexp = "^\\d{11}$")
	String tc;
	@NotNull
	LocalDate birthDate;
	@NotBlank
	String address;
}