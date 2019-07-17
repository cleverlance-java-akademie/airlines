package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entities.Airplane;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor;

import java.util.List;
import java.util.Optional;

public interface IAirplaneService {

    List<Airplane> getAllPlanes();

    void deletePlane(long id);

    void updatePlane(Airplane airplane);

    void addPlane(Airplane airplane);

    Optional<Airplane> getAirplaneById(long id);
}
