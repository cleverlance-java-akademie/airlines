package com.cleverlance.academy.airlines.repositories;

import com.cleverlance.academy.airlines.entities.Hangar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HangarsRepository extends JpaRepository<Hangar, Integer> {

}
