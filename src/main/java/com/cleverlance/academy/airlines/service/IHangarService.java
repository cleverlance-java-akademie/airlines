package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entities.Airplane;
import com.cleverlance.academy.airlines.entities.Hangar;

import java.util.List;
import java.util.Optional;

public interface IHangarService {

    List<Hangar> getAllHangars();

    void deleteHangar(long id);

    void updateHangar(Hangar hangar);

    void addHangar(Hangar hangar);

    void addAirplaneToHangar(final Hangar hangar, final Airplane airplane);

    Optional<Hangar> getHangarById(long id);
}
