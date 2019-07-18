package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Traveller;

import java.util.List;
import java.util.Optional;

public interface ITravellerService {
    Optional<Traveller> getTravellerById(Long travellerId);

    void createTraveller(final Traveller traveller);

    List<Traveller> getAll();
}
