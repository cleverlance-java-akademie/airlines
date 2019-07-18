package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepo extends JpaRepository <Flight, Long> {
}
