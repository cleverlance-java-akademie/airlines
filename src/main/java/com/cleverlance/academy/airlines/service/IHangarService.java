package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entities.Hangar;

import java.util.List;

public interface IHangarService {

    List<Hangar> getAllHangars();

    void deleteHangar(long id);

    void updateHangar(Hangar hangar);

    void addHangar(Hangar hangar);
}
