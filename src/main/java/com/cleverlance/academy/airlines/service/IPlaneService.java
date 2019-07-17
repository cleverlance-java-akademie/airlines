package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Plane;

import java.util.List;

public interface IPlaneService {

    List<Plane> getAllPlanes();

    void deletePlane(long id);

    void updatePlane(Plane plane);

    void createPlane(Plane plane);
}
