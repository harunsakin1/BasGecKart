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
import static com.haruns.basgeckart.constants.RestApis.*;

@AllArgsConstructor
@RestController
@RequestMapping(RECHARGE)
public class RechargeController {
	private final RechargeService rechargeService;
	
	@PostMapping(ADD_BALANCE)
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