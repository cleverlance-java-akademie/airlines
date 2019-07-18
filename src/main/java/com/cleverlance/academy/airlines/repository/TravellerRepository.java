package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.model.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravellerRepository extends JpaRepository<Traveller, Long> {
}
