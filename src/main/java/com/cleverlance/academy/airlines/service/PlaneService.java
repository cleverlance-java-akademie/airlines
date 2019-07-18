package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entities.Plane;
import com.cleverlance.academy.airlines.repositories.PlanesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneService implements IPlaneService{
    @Autowired
    private PlanesRepository planes;

    @Override
    public List<Plane> getAllPlanes() {
        return planes.findAll();
    }

    @Override
    public void deletePlane(final int id) {
        planes.deleteById(id);
    }

    @Override
    public void createPlane(final Plane plane) {
        planes.saveAndFlush(plane);
    }

    @Override
    public void updatePlane(final Plane plane) {
        planes.saveAndFlush(plane);
    }

    @Override
    public Optional<Plane> getPlane(final int plane) {
        return planes.findById(plane);
    }

    @Override
    public Optional<Plane> getPlaneByRegCode(final String registerCode) {
        return Optional.ofNullable(planes.getPlaneByCode(registerCode));
    }
}
