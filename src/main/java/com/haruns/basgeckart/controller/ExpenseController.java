package com.haruns.basgeckart.controller;

import com.haruns.basgeckart.dto.request.UseCardRequestDto;
import com.haruns.basgeckart.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.haruns.basgeckart.constants.RestApis.*;

@AllArgsConstructor
@RestController
@RequestMapping(EXPENSE)
public class ExpenseController {
	private final ExpenseService expenseService;
	
	@PostMapping(USE_CARD)
	public String useCard(@RequestBody @Valid UseCardRequestDto dto) {
		return expenseService.useCard(dto);
	}
}