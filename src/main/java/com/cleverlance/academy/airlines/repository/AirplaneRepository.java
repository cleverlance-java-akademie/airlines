package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {

}
