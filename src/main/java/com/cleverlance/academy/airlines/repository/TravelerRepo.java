package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.entity.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelerRepo extends JpaRepository<Traveler, Long> {
}