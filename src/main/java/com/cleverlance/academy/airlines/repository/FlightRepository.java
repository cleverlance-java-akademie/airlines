package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long>
{
}
