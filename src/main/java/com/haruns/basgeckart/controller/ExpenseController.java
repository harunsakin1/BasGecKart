package com.haruns.basgeckart.controller;

import com.haruns.basgeckart.dto.request.UseCardRequestDto;
import com.haruns.basgeckart.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/expense")
public class ExpenseController {
	private final ExpenseService expenseService;
	
	@PostMapping("/use-card")
	public String useCard(@RequestBody @Valid UseCardRequestDto dto) {
		return expenseService.useCard(dto);
	}
}