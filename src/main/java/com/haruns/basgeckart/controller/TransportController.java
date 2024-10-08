package com.haruns.basgeckart.controller;

import com.haruns.basgeckart.entity.Transport;
import com.haruns.basgeckart.service.TransportService;
import com.haruns.basgeckart.utility.enums.TransportType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transport")
public class TransportController {
	private final TransportService transportService;
	
	@GetMapping("/add-all-transports")
	public String addAllTransports() {
		Transport transport = Transport.builder()
		                               .transportType(TransportType.BUS)
		                               .price(10D)
		                               .build();
		Transport transport1 = Transport.builder()
		                                .transportType(TransportType.FERRY)
		                                .price(15D)
		                                .build();
		
		transportService.addTransport(transport);
		transportService.addTransport(transport1);
		
		return "Kayitlar basarili";
	}
}