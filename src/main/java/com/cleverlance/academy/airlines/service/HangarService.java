package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Airplane;
import com.cleverlance.academy.airlines.model.Hangar;
import com.cleverlance.academy.airlines.repository.AirplaneRepository;
import com.cleverlance.academy.airlines.repository.HangarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class HangarService implements IHangarService {

    @Autowired
    private HangarRepository repo;

    @Autowired
    private AirplaneRepository airRepo;


    @Override
    public Optional<Hangar> getHangarById(int id) {
        return repo.findById(id);
    }

    @Override
    public List<Hangar> getAllHangars() {
        return repo.findAll();
    }

    @Override
    public void addHangar(final Hangar hangar) {
        repo.saveAndFlush(hangar);
    }

    @Override
    public void removeHangar(final int id) {
        repo.deleteById(id);
    }

    @Override
    public void updateHangar(final Hangar hangar) {
        repo.saveAndFlush(hangar);
    }

    @Override
    public void parkAirplaneTiHangar(final Hangar hangar, final Airplane airplane) {
        final List<Airplane> list = hangar.getAirplanes();
        if (list == null) {
            hangar.setAirplanes(new ArrayList<>());
        }
        hangar.getAirplanes().add(airplane);
        updateHangar(hangar);
    }
}
