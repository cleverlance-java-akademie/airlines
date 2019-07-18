package com.cleverlance.academy.airlines.controller;

import com.cleverlance.academy.airlines.model.Flight;
import com.cleverlance.academy.airlines.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    IFlightService service;

    @RequestMapping(path = "/flight", method = RequestMethod.GET)
    public List<Flight> getAllFlights() {
        return service.getAllFlights();
    }

    @RequestMapping(path = "/flight", method = RequestMethod.POST)
    public void createFlight(@RequestBody Flight flight) {
        service.createFlight(flight);
    }

}
