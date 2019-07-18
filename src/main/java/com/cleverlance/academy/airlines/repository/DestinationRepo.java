package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepo extends JpaRepository<Destination, Long> {
}
