package com.cleverlance.academy.airlines.servicies;

import com.cleverlance.academy.airlines.entities.Airplane;

import java.util.List;
import java.util.Optional;

public interface IPlaneService {

    List<Airplane> getAllAirplanes();

    void deletePlane(long id);

    void updatePlane(Airplane aP);

    void createPlane(Airplane aP);

    Optional<Airplane> getPlaneById(Long id);

    Optional<Airplane> getPlaneByCode(String code);
}
