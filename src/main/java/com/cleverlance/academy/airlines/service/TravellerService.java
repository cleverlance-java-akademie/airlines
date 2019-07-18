package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Traveler;
import com.cleverlance.academy.airlines.repository.TravellerReposotiry;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TravellerService implements ITravellerService {

    @Autowired
    private TravellerReposotiry repo;

    @Override
    public List<Traveler> getAllTravellers() {
        return repo.findAll();
    }

    @Override
    public void createTraveller(final Traveler traveler) {
        repo.saveAndFlush(traveler);
    }

    @Override
    public void updateTraveller(final Traveler traveler) {
        repo.saveAndFlush(traveler);
    }

    @Override
    public void deleteTraveller(final Long travelerId) {
        repo.delete(repo.getOne(travelerId));
    }
}
