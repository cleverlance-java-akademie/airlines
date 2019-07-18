package com.cleverlance.academy.airlines.repositories;

import com.cleverlance.academy.airlines.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
