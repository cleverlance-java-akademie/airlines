package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.model.Flight;
import com.cleverlance.academy.airlines.service.IAirportService;
import com.cleverlance.academy.airlines.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
public class FlightController {
    @Autowired
    IFlightService flightService;

    @Autowired
    IAirportService airportService;

    @RequestMapping(path = "/flights", method = RequestMethod.GET)
    public List<Flight> getAllFlights() {
        return flightService.getAll();
    }

    @RequestMapping(path = "/flights/{code}", method = RequestMethod.POST)
    public void createFlight(@PathVariable String code) {

        ZonedDateTime date = ZonedDateTime.now();
//
//        Flight flight = Flight.builder()
//                .start(start)
//                .end(end)
//                .code(code)
//                .dateTime(date).build();
//        flightService.createFlight(flight);
    }
}
