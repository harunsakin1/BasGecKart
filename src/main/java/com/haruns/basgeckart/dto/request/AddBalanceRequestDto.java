package com.haruns.basgeckart.dto.request;

import com.haruns.basgeckart.utility.enums.PaymentType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AddBalanceRequestDto {
	@NotNull
	Long cardId;
	@NotNull
	Double amount;
	@NotNull
	PaymentType paymentType;
}