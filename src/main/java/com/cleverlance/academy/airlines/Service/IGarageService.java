package com.cleverlance.academy.airlines.Service;

import com.cleverlance.academy.airlines.entity.Aircraft;
import com.cleverlance.academy.airlines.entity.Garage;

import java.util.List;

public interface IGarageService {

    List<Garage> getAllGarages();

    void deleteGarage(final int id);

    void updateGarage(final Garage garage);

    void createGarage(final Garage garage);
}
