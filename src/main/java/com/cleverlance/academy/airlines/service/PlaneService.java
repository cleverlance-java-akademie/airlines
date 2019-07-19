package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Plane;
import com.cleverlance.academy.airlines.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneService implements IPlaneService {

    @Autowired
    private PlaneRepository planeRepository;

    @Override
    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    @Override
    public void deletePlane(final Long id) {
        planeRepository.deleteById(id);
    }

    @Override
    public void updatePlane(final Plane plane) {
        planeRepository.saveAndFlush(plane);
    }

    @Override
    public void createPlane(final Plane plane) {
        planeRepository.saveAndFlush(plane);
    }

    @Override
    public Optional<Plane> getPlaneById(final Long planeId) {
        return planeRepository.findById(planeId);
    }

    @Override
    public Optional<Plane> getPlaneByRegistrationCode(final String registrationCode) {
        return Optional.ofNullable(
                planeRepository.getPlaneByRegistrationCode(registrationCode));
    }
}