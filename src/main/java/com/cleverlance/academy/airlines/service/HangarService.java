package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entities.Hangar;
import com.cleverlance.academy.airlines.repositories.HangarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangarService implements IHangarService {

    @Autowired
    private HangarRepository hangarRepository;

    @Override
    public List<Hangar> getAllHangars() {
        return hangarRepository.findAll();
    }

    @Override
    public void deleteHangar(long id) {
        hangarRepository.deleteById(id);
    }

    @Override
    public void updateHangar(Hangar hangar) {
        hangarRepository.saveAndFlush(hangar);
    }

    @Override
    public void addHangar(Hangar hangar) {
        hangarRepository.saveAndFlush(hangar);
    }
}
