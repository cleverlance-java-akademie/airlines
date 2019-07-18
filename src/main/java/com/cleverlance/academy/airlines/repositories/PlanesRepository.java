package com.cleverlance.academy.airlines.repositories;

import com.cleverlance.academy.airlines.entities.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//@Component
//@Repository
public interface PlanesRepository extends JpaRepository<Plane, Integer> {

    @Query("select plane from Plane plane where plane.registerCode = :regCode")
    Plane getPlaneByCode(@Param("regCode")String code);
}