package com.cleverlance.academy.airlines.repositories;

import com.cleverlance.academy.airlines.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
