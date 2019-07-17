package com.cleverlance.academy.airlines.servicies;

import com.cleverlance.academy.airlines.entities.Airplane;
import com.cleverlance.academy.airlines.entities.Hangar;

import java.util.List;
import java.util.Optional;

public interface IHangarService {

    List<Hangar> getAllHangars();

    void deleteHangar(long id);

    void updateHangar(Hangar h);

    void createHangar(Hangar h);

    Optional<Hangar> getHangarById(Long hangar);

    void addPlaneToHangar(Hangar h, Airplane aP);
}
