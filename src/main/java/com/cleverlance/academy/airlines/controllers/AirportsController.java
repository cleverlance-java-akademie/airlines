package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.entity.Destination;
import com.cleverlance.academy.airlines.service.AirportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirportsController {

    @Autowired
    AirportsService airportsService;

    @RequestMapping(path = "/airports", method = RequestMethod.GET)
    public List<Destination> getAirports(){
        return airportsService.getAllAirports();
    }
}
