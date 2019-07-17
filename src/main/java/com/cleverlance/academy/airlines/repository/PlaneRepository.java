package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PlaneRepository extends JpaRepository<Plane, Long> {

}
