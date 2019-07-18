package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entities.Hangar;
import com.cleverlance.academy.airlines.entities.Plane;
import com.cleverlance.academy.airlines.repositories.HangarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HangarService implements IHangarService {
    @Autowired
    HangarsRepository hangars;

    @Override
    public List<Hangar> getAllHangars() {
        return hangars.findAll();
    }

    @Override
    public void deleteHangar(final int id) {
        hangars.deleteById(id);
    }

    @Override
    public void createHangar(final Hangar hangar) {
        hangars.saveAndFlush(hangar);
    }

    @Override
    public Optional<Hangar> getHangarById(final int hangar) {
        return hangars.findById(hangar);
    }

    @Override
    public void updateHangar(final Hangar hangar) {
        hangars.saveAndFlush(hangar);
    }

    @Override
    public void addPlane(final Hangar hangar, final Plane plane) {
        final List<Plane> list = hangar.getPlanes();
        if(list == null){
            hangar.setPlanes(new ArrayList<>());
        }
        hangar.getPlanes().add(plane);
        updateHangar(hangar);
    }
}
