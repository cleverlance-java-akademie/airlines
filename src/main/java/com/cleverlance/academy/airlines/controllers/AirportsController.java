package com.cleverlance.academy.airlines.controllers;


import com.cleverlance.academy.airlines.model.Destination;
import com.cleverlance.academy.airlines.service.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirportsController {

    @Autowired
    IAirportService airportService;

    @RequestMapping(path = "/airports", method = RequestMethod.GET)
    public List<Destination> getAllAirports() {
        return airportService.getAllAirports();
    }

    @RequestMapping(path = "/airports/random", method = RequestMethod.GET)
    public Destination getRandomAirport() {
        return airportService.getARandomAirport();
    }
}
