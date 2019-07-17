package com.cleverlance.academy.airlines.Service;

import com.cleverlance.academy.airlines.entity.Aircraft;

import java.util.List;

public interface IAircraftService {

    List<Aircraft> getAllPlanes();

    void deletePlane(final int id);

    void updatePlane(final Aircraft aircraft);

    void createPlane(final Aircraft aircraft);

}
