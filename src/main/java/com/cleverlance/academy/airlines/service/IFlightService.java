package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Flight;

import java.util.List;

public interface IFlightService {

    List<Flight> getAllFlights();

    void createFlight(final Flight flight);

    void updateFlight(final Flight flight);

    void deleteFlight(final long flightId);
}
