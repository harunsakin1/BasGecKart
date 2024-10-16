package com.haruns.basgeckart.dto.request;

import com.haruns.basgeckart.utility.enums.CardType;
import jakarta.validation.constraints.NotBlank;

public record CreateSpecialCardRequestDto(
		@NotBlank
		String tc,
		CardType cardType
) {
}