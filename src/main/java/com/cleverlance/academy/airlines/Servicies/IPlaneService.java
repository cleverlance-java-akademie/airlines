package com.cleverlance.academy.airlines.Servicies;

import com.cleverlance.academy.airlines.entities.Airplane;

import java.util.List;

public interface IPlaneService {

    List<Airplane> getAllAirplanes();

    void deletePlane(long id);

    void updatePlane(long id, Airplane aP);

    void createPlane(Airplane aP);
}
