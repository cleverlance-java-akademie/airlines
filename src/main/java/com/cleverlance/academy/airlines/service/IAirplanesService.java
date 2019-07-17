package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Airplane;

import java.util.List;
import java.util.Optional;

public interface IAirplanesService {

    List<Airplane> getAirplanes();

    void addAirplane(Airplane airplane);

    void removeAirplane(int id);

    void updateAirplane(Airplane airplane);

    Optional<Airplane> getAirplaneById(int id);

    Optional<Airplane> getAirplaneByRegistrationCode(String registrationCode);
}
