package com.cleverlance.academy.airlines.servicies;

import com.cleverlance.academy.airlines.entities.Hangar;

import java.util.List;

public interface IHangarService {

    List<Hangar> getAllHangars();

    void deleteHangar(long id);

    void updateHangar(Hangar h);

    void createHangar(Hangar h);
}
