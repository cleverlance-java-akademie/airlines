package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Flight;
import com.cleverlance.academy.airlines.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class FlightService implements IFlightService {

    @Autowired
    FlightRepository flightRepo;

    @Override
    public List<Flight> getAllFlights() {
        return flightRepo.findAll();
    }

    @Override
    public Flight createFlight(Flight flight) {
        flightRepo.saveAndFlush(flight);
        return flight;
    }
}
