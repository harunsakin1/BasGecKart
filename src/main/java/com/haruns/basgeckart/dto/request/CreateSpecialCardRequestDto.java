package com.haruns.basgeckart.dto.request;

import com.haruns.basgeckart.utility.enums.CardType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CreateSpecialCardRequestDto {
	@NotBlank
	String tc;
	CardType cardType;
	
}