package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Airplane;

import java.util.List;

public interface IAirplanesService {

    List<Airplane> getAirplanes();

    void addAirplane(Airplane airplane);

    void removeAirplane(int regPlate);

    void updateAirplane(Airplane airplane);
}
