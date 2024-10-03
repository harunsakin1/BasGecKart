package com.haruns.basgeckart.repository;

import com.haruns.basgeckart.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}