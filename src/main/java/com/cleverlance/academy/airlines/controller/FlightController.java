package com.cleverlance.academy.airlines.controller;

import com.cleverlance.academy.airlines.model.Destination;
import com.cleverlance.academy.airlines.model.Flight;
import com.cleverlance.academy.airlines.service.FlightService;
import com.cleverlance.academy.airlines.service.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightController
{
    @Autowired
    private FlightService flightService;
    @Autowired
    private IAirportService airportService;


    @RequestMapping(path = "/flights", method = RequestMethod.GET)
    public List<Flight> getAllFlights()
    {
        return flightService.getAllFlights();
    }

    @RequestMapping(path = "/flights", method = RequestMethod.POST)
    public void createFlight()
    {
        final Destination start = airportService.getRandomAirport();
        Destination end = airportService.getRandomAirport();
        while (start.equals(end))
        {
            end = airportService.getRandomAirport();
        }

        flightService.createFlight(new Flight());
    }
}
