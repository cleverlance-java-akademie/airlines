package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Flight;
import com.cleverlance.academy.airlines.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService implements IFlightService {

    @Autowired
    FlightRepository flightRepository;

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public void createFlight(final Flight flight) {
        flightRepository.saveAndFlush(flight);
    }

    @Override
    public void updateFlight(final Flight flight) {

    }

    @Override
    public void deleteFlight(final long flightId) {

    }
}
