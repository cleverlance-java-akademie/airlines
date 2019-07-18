package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Traveler;

import java.util.List;
import java.util.Optional;

public interface ITravelerService
{
    List<Traveler> getAllTravelers();

    void createTraveler(Traveler traveler);

    Optional<Traveler> getTravelerById(Long id);
}
