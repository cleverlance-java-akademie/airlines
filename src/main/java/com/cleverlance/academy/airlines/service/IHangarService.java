package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Hangar;
import com.cleverlance.academy.airlines.model.Plane;

import java.util.List;
import java.util.Optional;

public interface IHangarService
{
    List<Hangar> getAllHangars();

    void createHangar(Hangar hangar);

    void update(Hangar hangar);

    void deleteHangar(long id);

    Optional<Hangar> getHangarById(Long hangarId);

    void addPlaneToHangar(Hangar hangar, Plane plane);
}
