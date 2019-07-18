package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Flight;

import java.util.List;

public interface IFlightService {
    List<Flight> getAllFlights();
    Flight createFlight(Flight flight);
}
