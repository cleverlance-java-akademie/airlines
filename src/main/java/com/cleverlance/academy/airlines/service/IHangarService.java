package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Airplane;
import com.cleverlance.academy.airlines.model.Hangar;

import java.util.List;
import java.util.Optional;

public interface IHangarService {

    List<Hangar> getAllHangars();
    void addHangar(Hangar hangar);
    void removeHangar(int id);
    void updateHangar(Hangar hangar);
    void parkAirplaneTiHangar(final Hangar hangar, final Airplane airplane);
    Optional<Hangar> getHangarById(int id);

}
