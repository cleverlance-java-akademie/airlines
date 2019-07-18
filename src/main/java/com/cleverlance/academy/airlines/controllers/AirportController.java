package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.client.AirportClient;
import com.cleverlance.academy.airlines.client.IAirportClient;
import com.cleverlance.academy.airlines.entities.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirportController {

    @Autowired
    private IAirportClient airportClient;

    @RequestMapping(value = "/airports", method = RequestMethod.GET)
    public List<Destination> getAllAirports(){
        return airportClient.getAllAirports();
    }
}