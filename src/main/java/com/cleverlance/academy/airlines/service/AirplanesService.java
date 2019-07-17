package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Airplane;
import com.cleverlance.academy.airlines.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirplanesService implements IAirplanesService {

    @Autowired
    private AirplaneRepository repo;

    @Override
    public List<Airplane> getAirplanes() {
        return repo.findAll();
    }

    @Override
    public void addAirplane(final Airplane airplane) {
        repo.saveAndFlush(airplane);
    }

    @Override
    public void removeAirplane(final int regPlate) {
        repo.deleteById(regPlate);
    }

    @Override
    public void updateAirplane(final Airplane airplane) {
        repo.saveAndFlush(airplane);
    }
}
