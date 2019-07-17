package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Hangar;

import java.util.List;

public interface IHangarService {

    List<Hangar> getAllHangars();
    void addHangar(Hangar hangar);
    void removeHangar(int id);
    void updateHangar(Hangar hangar);

}
