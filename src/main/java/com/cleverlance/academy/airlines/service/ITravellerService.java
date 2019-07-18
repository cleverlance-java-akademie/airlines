package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Traveler;

import java.util.List;

public interface ITravellerService {

    List<Traveler> getAllTravellers();

    void createTraveller(final Traveler traveler);

    void updateTraveller(final Traveler traveler);

    void deleteTraveller(final Long travelerId);
}
