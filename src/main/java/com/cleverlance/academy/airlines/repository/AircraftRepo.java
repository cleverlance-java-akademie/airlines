package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AircraftRepo extends JpaRepository<Aircraft, Integer> {

    @Query("SELECT aircraft FROM Aircraft aircraft where aircraft.registration = :regCode")
    Aircraft getPlaneByRegCode ( @Param("regCode")String registrationCode);
}
