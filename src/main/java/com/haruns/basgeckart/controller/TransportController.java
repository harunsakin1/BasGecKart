package com.haruns.basgeckart.controller;

import com.haruns.basgeckart.entity.Transport;
import com.haruns.basgeckart.service.TransportService;
import com.haruns.basgeckart.utility.enums.TransportType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.haruns.basgeckart.constants.RestApis.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(TRANSPORT)
public class TransportController {
	private final TransportService transportService;
	
	@GetMapping(ADD_ALL_TRANSPORTS)
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