package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Traveller;
import com.cleverlance.academy.airlines.repository.TravellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravellerService implements ITravellerService {

    @Autowired
    TravellerRepository travellerRepository;

    @Override
    public Optional<Traveller> getTravellerById(final Long travellerId) {
        return travellerRepository.findById(travellerId);
    }

    @Override
    public void createTraveller(final Traveller traveller) {
        travellerRepository.saveAndFlush(traveller);
    }

    @Override
    public List<Traveller> getAll() {
        return travellerRepository.findAll();
    }
}
