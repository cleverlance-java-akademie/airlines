package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {

    @Query("select airplane from Airplane airplane where airplane.registrationCode = :registrationCode")
    Optional<Airplane> getAirplaneByRegistrationCode(@Param("registrationCode") String registrationCode);

}
