package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.entities.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelerRepository  extends JpaRepository<Traveler, Long> {
}
