package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entity.Aircraft;
import com.cleverlance.academy.airlines.entity.Garage;

import java.util.List;
import java.util.Optional;

public interface IGarageService {

    List<Garage> getAllGarages();

    void deleteGarage(final int id);

    void updateGarage(final Garage garage);

    void createGarage(final Garage garage);

    Optional<Garage> getGarageById(int garageId);

    void addPlaneToGarage(Garage garage, Aircraft aircraft);
}
