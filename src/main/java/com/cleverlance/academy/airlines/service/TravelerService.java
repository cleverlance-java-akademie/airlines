package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Traveler;
import com.cleverlance.academy.airlines.repository.TravelerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TravelerService implements ITravelerService {

    @Autowired
    TravelerRepository travelerRepo;

    @Override
    public List<Traveler> getAllTravelers() {
        return travelerRepo.findAll();
    }

    @Override
    public Traveler addTraveler(Traveler traveler) {
        travelerRepo.saveAndFlush(traveler);
        return traveler;
    }
}
