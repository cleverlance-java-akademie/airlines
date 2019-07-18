package com.cleverlance.academy.airlines.controller;


import com.cleverlance.academy.airlines.model.Traveler;
import com.cleverlance.academy.airlines.service.TravelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TravellerController {

    @Autowired
    private TravelerService service;

    @RequestMapping(path = "/traveler", method = RequestMethod.GET)
    public List<Traveler> getAllTravelers() {
        return service.getAllTravelers();
    }

    @RequestMapping(path = "/traveler", method = RequestMethod.POST)
    public void addTraveler(@RequestBody Traveler traveler) {
        service.addTraveler(traveler);
    }
}
