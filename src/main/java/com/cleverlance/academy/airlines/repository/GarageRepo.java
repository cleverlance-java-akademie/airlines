package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.entity.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GarageRepo extends JpaRepository<Garage, Integer> {
}
