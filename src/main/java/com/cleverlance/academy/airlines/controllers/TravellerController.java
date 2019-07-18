package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.model.Traveller;
import com.cleverlance.academy.airlines.service.ITravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TravellerController {

    @Autowired
    ITravellerService travellerService;

    @RequestMapping(path = "/travellers", method = RequestMethod.GET)
    public List<Traveller> getAll() {
        return travellerService.getAll();
    }

    @RequestMapping(path = "/travellers/{id}", method = RequestMethod.GET)
    public Optional<Traveller> getTravellerById(@PathVariable Long id) {
        return travellerService.getTravellerById(id);
    }

    @RequestMapping(path = "/travellers", method = RequestMethod.POST)
    public void createTraveller(@RequestBody Traveller traveller) {
        travellerService.createTraveller(traveller);
    }
}
