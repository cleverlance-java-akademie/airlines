package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entity.Garage;
import com.cleverlance.academy.airlines.repository.GarageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageService implements IGarageService {

    @Autowired
    private GarageRepo garageRepo;

    @Override
    public List<Garage> getAllGarages() {
        return garageRepo.findAll();
    }

    @Override
    public void deleteGarage(int id) {
        garageRepo.deleteById(id);
    }

    @Override
    public void updateGarage(Garage garage) {
        garageRepo.saveAndFlush(garage);
    }

    @Override
    public void createGarage(Garage garage) {
        garageRepo.saveAndFlush(garage);
    }
}
