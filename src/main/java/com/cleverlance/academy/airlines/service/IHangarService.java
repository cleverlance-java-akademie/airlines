package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entities.Hangar;

import java.util.List;

public interface IHangarService {
    List<Hangar> getAllHangars();
    void deleteHangar (int id);
    void createHangar (Hangar hangar);
    void updateHangar (Hangar hanga);
}
