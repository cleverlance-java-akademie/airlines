package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.client.AirportClient;
import com.cleverlance.academy.airlines.repositories.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinationService implements IDestinationService{

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private AirportClient airportClient;

    @Override
    public void storeAllDestination() {
        destinationRepository.saveAll(airportClient.getAllAirports());
    }
}
