package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Plane;

import java.util.List;
import java.util.Optional;

public interface IPlaneService
{

    List<Plane> getAllPlanes();

    void deletePlane(long id);

    void updatePlane(Plane plane);

    Optional<Plane> getPlaneById(Long planeId);

    void createPlane(Plane plane);

    Optional<Plane> getPlaneByRegistrationCode(String registrationCode);
}
