package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entity.Aircraft;

import java.util.List;
import java.util.Optional;

public interface IAircraftService {

    List<Aircraft> getAllPlanes();

    void deletePlane(final int id);

    void updatePlane(final Aircraft aircraft);

    void createPlane(final Aircraft aircraft);

    Optional<Aircraft> getPlaneByRegCode (String regCode);

}
