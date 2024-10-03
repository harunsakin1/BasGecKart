package com.haruns.basgeckart.controller;

import com.haruns.basgeckart.service.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transport")
public class TransportController {
	private final TransportService transportService;
	
	
}