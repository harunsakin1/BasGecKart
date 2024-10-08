package com.haruns.basgeckart.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UseCardDto {
	@NotNull
	Long cardId;
	@NotNull
	Long transportId;
}