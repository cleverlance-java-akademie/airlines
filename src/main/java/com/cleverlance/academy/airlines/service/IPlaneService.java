package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entities.Plane;

import java.util.List;

public interface IPlaneService {
    List<Plane> getAllPlanes();
    void deletePlane (int id);
    void createPlane (Plane plane);
    void updatePlane (Plane plane);
}
