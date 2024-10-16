package com.haruns.basgeckart.dto.request;

import com.haruns.basgeckart.utility.enums.PaymentType;
import jakarta.validation.constraints.NotNull;

public record AddBalanceRequestDto(
		@NotNull
		String cardNumber,
		@NotNull
		Double amount,
		@NotNull
		PaymentType paymentType
) {
}