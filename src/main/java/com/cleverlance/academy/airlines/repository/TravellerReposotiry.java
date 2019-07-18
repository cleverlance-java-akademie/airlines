package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.model.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravellerReposotiry extends JpaRepository<Traveler, Long> {

}
