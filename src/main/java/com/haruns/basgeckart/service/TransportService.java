package com.haruns.basgeckart.service;

import com.haruns.basgeckart.repository.TransportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransportService {
	private final TransportRepository transportRepository;
	
}