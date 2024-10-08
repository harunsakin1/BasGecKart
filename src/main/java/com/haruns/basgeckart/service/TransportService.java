package com.haruns.basgeckart.service;

import com.haruns.basgeckart.entity.Transport;
import com.haruns.basgeckart.repository.TransportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TransportService {
	private final TransportRepository transportRepository;
	public void addTransport(Transport transport) {
		transportRepository.save(transport);
	}
	public Optional<Transport> findTransportById(Long transportId) {
		return transportRepository.findById(transportId);
	}
}