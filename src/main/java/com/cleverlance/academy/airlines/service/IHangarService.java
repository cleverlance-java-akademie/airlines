package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entities.Hangar;
import com.cleverlance.academy.airlines.entities.Plane;

import java.util.List;
import java.util.Optional;

public interface IHangarService {
    List<Hangar> getAllHangars();
    void deleteHangar (int id);
    void createHangar (Hangar hangar);
    Optional<Hangar> getHangarById(int Hangar);
    void updateHangar (Hangar hanga);
    void addPlane (Hangar hangar, Plane plane);
}
