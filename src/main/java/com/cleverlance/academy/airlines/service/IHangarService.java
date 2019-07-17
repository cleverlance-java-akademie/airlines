package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Hangar;
import com.cleverlance.academy.airlines.model.Plane;

import java.util.List;
import java.util.Optional;

public interface IHangarService {

    List<Hangar> getAll();

    void deleteHangar(Long id);

    void updateHangar(Hangar hangar);

    void createHangar(Hangar hangar);

    void addPlaneToHangar(Hangar hangar, Plane plane);

    Optional<Hangar> getHangarById(Long hangarId);
}
