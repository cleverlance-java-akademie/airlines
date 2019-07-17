package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.entities.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public interface AirPlaneRepository extends JpaRepository<Airplane, Long> {


}
