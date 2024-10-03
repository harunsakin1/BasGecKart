package com.haruns.basgeckart.controller;

import com.haruns.basgeckart.service.TransportService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transport")
public class TransportController {
	private TransportService transportService;
	
	public TransportController(TransportService transportService) {
		this.transportService = transportService;
	}
}