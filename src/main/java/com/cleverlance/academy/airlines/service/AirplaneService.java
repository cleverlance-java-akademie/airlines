package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entities.Airplane;
import com.cleverlance.academy.airlines.repositories.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneService implements IAirplaneService {


    @Autowired
    private AirplaneRepository airplaneRepository;

    @Override
    public List<Airplane> getAllPlanes() {
        return airplaneRepository.getAirplanes();
    }

    @Override
    public void deletePlane(long id) {
        airplaneRepository.deleteAirplane(id);
    }

    @Override
    public void updatePlane(Airplane airplane) {
        airplaneRepository.updateAirplane(airplane);
    }

    @Override
    public void addPlane(Airplane airplane) {
        airplaneRepository.createAirplane(airplane);
    }
}
