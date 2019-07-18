package com.cleverlance.academy.airlines.controller;

import com.cleverlance.academy.airlines.client.AirportClient;
import com.cleverlance.academy.airlines.entities.Destination;
import com.cleverlance.academy.airlines.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AirportsController {

    @Autowired
    private AirportService airportService;

    @RequestMapping(path = "/airports", method = RequestMethod.GET)
    public List<Destination> listAllAirports(){
        return airportService.getAllAirports();
    }

}
