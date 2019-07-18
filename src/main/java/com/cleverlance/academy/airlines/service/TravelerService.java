package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Traveler;
import com.cleverlance.academy.airlines.repository.TravelerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelerService implements ITravelerService
{
    @Autowired
    private TravelerRepository travelerRepository;

    @Override
    public List<Traveler> getAllTravelers()
    {
        return travelerRepository.findAll();
    }

    @Override
    public void createTraveler(final Traveler traveler)
    {
        travelerRepository.saveAndFlush(traveler);
    }

    @Override
    public Optional<Traveler> getTravelerById(final Long id)
    {
        return travelerRepository.findById(id);
    }
}
