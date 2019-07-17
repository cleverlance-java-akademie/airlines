package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Hangar;
import com.cleverlance.academy.airlines.repository.HangarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangarService implements IHangarService
{
    @Autowired
    private HangarRepository hangarRepository;

    @Override
    public List<Hangar> getAllHangars()
    {
        return hangarRepository.findAll();
    }

    @Override
    public void createHangar(final Hangar hangar)
    {
        hangarRepository.saveAndFlush(hangar);
    }

    @Override
    public void update(final Hangar hangar)
    {
        hangarRepository.saveAndFlush(hangar);
    }

    @Override
    public void deleteHangar(final long id)
    {
        hangarRepository.deleteById(id);
    }
}
