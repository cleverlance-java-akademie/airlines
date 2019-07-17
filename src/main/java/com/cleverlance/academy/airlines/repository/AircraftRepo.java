package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AircraftRepo extends JpaRepository<Aircraft, Integer> {

}
