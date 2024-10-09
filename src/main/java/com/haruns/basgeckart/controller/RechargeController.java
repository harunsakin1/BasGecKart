package com.haruns.basgeckart.controller;

import com.haruns.basgeckart.dto.request.AddBalanceRequestDto;
import com.haruns.basgeckart.service.RechargeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/recharge")
public class RechargeController {
	private final RechargeService rechargeService;
	
	@PostMapping("/add-recharge")
	public void addRecharge(AddBalanceRequestDto dto) {
		rechargeService.addRecharge(dto);
	}
	
	@PostMapping("/add-balance")
	public ResponseEntity<String> addBalance (@RequestBody @Valid AddBalanceRequestDto dto) {
		try {
			rechargeService.addBalance(dto);
			return ResponseEntity.ok("Bakiye eklendi");
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Bakiye eklenirken hata !!");
		}
	}
}