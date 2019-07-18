package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entity.Flight;
import com.cleverlance.academy.airlines.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService implements IFlightService {

    @Autowired
    private FlightRepo flightRepo;

    @Override
    public void createFlight(Flight flight) {
        flightRepo.saveAndFlush(flight);
    }
}
