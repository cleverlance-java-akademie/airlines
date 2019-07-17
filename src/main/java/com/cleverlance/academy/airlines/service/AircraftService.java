package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entity.Aircraft;
import com.cleverlance.academy.airlines.repository.AircraftRepo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftService implements IAircraftService {

    @Autowired
    private AircraftRepo aircraftRepo;

    @Override
    public List<Aircraft> getAllPlanes() {
        return aircraftRepo.findAll();
    }

    @Override
    public void deletePlane(int id) {
        aircraftRepo.deleteById(id);
    }

    @Override
    public void updatePlane(Aircraft aircraft) {
        aircraftRepo.saveAndFlush(aircraft);
    }

    @Override
    public void createPlane(Aircraft aircraft) {
        aircraftRepo.
        saveAndFlush(aircraft);
    }

    public Optional<Aircraft> getAircraftById (int aircraftId){
        return aircraftRepo.findById(aircraftId);
    }
}
