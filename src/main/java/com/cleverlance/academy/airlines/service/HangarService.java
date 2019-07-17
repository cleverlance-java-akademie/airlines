package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entities.Hangar;
import com.cleverlance.academy.airlines.repositories.HangarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void updateHangar(final Hangar hangar) {
        hangars.saveAndFlush(hangar);
    }
}
