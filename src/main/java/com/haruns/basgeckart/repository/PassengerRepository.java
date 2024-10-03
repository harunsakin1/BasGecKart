package com.haruns.basgeckart.repository;

import com.haruns.basgeckart.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {

}