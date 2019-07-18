package com.cleverlance.academy.airlines.controller;

import com.cleverlance.academy.airlines.model.Destination;
import com.cleverlance.academy.airlines.service.IDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirportController {

    @Autowired
    private IDestinationService destinationService;

    @GetMapping("/airports")
    public List<Destination> getAllAirports() {
        return destinationService.getAll();
    }



}
