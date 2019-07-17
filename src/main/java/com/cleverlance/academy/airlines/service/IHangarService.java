package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Hangar;

import java.util.List;

public interface IHangarService
{
    List<Hangar> getAllHangars();
    void createHangar(Hangar hangar);
    void update(Hangar hangar);
    void deleteHangar(long id);
}
