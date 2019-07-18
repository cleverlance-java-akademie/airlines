package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entity.Traveler;
import com.cleverlance.academy.airlines.repository.TravelerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelerService implements ITravelerService {

    @Autowired
    TravelerRepo travelerRepo;

    @Override
    public void createTraveler(Traveler traveler) {
        travelerRepo.saveAndFlush(traveler);
    }
}
