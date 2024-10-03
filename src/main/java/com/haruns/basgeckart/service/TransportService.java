package com.haruns.basgeckart.service;

import com.haruns.basgeckart.repository.TransportRepository;
import org.springframework.stereotype.Service;

@Service
public class TransportService {
	private TransportRepository transportRepository;
	
	public TransportService(TransportRepository transportRepository) {
		this.transportRepository = transportRepository;
	}
}