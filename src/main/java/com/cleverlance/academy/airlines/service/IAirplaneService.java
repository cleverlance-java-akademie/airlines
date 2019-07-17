package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entities.Airplane;

import java.util.List;

public interface IAirplaneService {

    List<Airplane> getAllPlanes();

    void deletePlane(long id);

    void updatePlane(Airplane airplane);

    void addPlane(Airplane airplane);
}
