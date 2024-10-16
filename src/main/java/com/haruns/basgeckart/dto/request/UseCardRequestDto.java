package com.haruns.basgeckart.dto.request;

import jakarta.validation.constraints.NotNull;

public record UseCardRequestDto(
		@NotNull
		Long cardId,
		@NotNull
		Long transportId
) {
}