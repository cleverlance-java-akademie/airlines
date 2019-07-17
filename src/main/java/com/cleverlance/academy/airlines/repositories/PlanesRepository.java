package com.cleverlance.academy.airlines.repositories;

import com.cleverlance.academy.airlines.entities.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

//@Component
//@Repository
public interface PlanesRepository extends JpaRepository<Plane, Integer> {

}