package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entities.Airplane;
import com.cleverlance.academy.airlines.entities.Hangar;
import com.cleverlance.academy.airlines.repositories.HangarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public void addAirplaneToHangar(Hangar hangar, Airplane airplane) {
        final List<Airplane> list = hangar.getAirplanes();
        if(list==null){
            hangar.setAirplanes(new ArrayList<>());
        }
        hangar.getAirplanes().add(airplane);
        updateHangar(hangar);

    }

    @Override
    public Optional<Hangar> getHangarById(long id) {
        return hangarRepository.findById(id);
    }
}
