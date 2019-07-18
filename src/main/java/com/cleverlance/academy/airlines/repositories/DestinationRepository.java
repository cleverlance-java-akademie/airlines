package com.cleverlance.academy.airlines.repositories;

import com.cleverlance.academy.airlines.entities.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository  extends JpaRepository<Destination, Long> {
}
