package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Traveler;

import java.util.List;

public interface ITravelerService {
    List<Traveler> getAllTravelers();
    Traveler addTraveler(Traveler traveler);
}
