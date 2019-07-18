package com.cleverlance.academy.airlines.servicies;

import com.cleverlance.academy.airlines.entities.Destination;

import java.util.List;

public interface IDestinationService {

    List<Destination> getAllDestinations();

    void updateDestinations();
}
