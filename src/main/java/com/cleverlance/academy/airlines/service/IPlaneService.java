package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entities.Plane;

import java.util.List;
import java.util.Optional;

public interface IPlaneService {
    List<Plane> getAllPlanes();
    void deletePlane (int id);
    void createPlane (Plane plane);
    void updatePlane (Plane plane);
    Optional<Plane> getPlane(int plane);
    Optional<Plane> getPlaneByRegCode(String registerCode);
}
