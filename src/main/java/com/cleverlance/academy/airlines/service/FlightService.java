package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Flight;
import com.cleverlance.academy.airlines.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService implements IFlightService {

    @Autowired
    FlightRepository flightRepository;

    @Override
    public Optional<Flight> getFlightById(Long flightId) {
        return flightRepository.findById(flightId);
    }

    @Override
    public void createFlight(final Flight flight) {
        flightRepository.saveAndFlush(flight);
    }

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }
}
