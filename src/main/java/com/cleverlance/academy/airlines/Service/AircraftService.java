package com.cleverlance.academy.airlines.Service;

import com.cleverlance.academy.airlines.entity.Aircraft;
import com.cleverlance.academy.airlines.repository.AircraftRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
