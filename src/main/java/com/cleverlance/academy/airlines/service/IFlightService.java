package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Flight;

import java.util.List;
import java.util.Optional;

public interface IFlightService {

    Optional<Flight> getFlightById(Long flightId);

    void createFlight(final Flight flight);

    List<Flight> getAll();

}
