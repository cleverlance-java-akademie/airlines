package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Hangar;
import com.cleverlance.academy.airlines.repository.HangarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HangarService implements IHangarService {

    @Autowired
    private HangarRepository repo;

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
}
