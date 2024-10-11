package com.haruns.basgeckart.repository;

import com.haruns.basgeckart.entity.Passenger;
import com.haruns.basgeckart.views.VwPassenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {

	 Passenger findByTc(String tc);
	
	 @Query("select new com.haruns.basgeckart.views.VwPassenger(p.name, p.surname, p.avatar) from Passenger p")
	List<VwPassenger> findAllPassengers();
}