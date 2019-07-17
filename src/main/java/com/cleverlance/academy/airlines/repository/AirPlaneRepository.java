package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.entities.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


@Service
public interface AirPlaneRepository extends JpaRepository<Airplane, Long> {

    @Query("select plane from Airplane plane where plane.code = :code")
    Airplane getPlaneByCode(@Param("code") String code);

}
