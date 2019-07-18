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
    private FlightRepository flightRepository;

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    @Override
    public void delete(final Long aLong) {
        flightRepository.deleteById(aLong);
    }

    @Override
    public void update(final Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public void create(final Flight flight) {
        flightRepository.save(flight);

    }

    @Override
    public Optional<Flight> getById(final Long aLong) {
        return flightRepository.findById(aLong);
    }
}
