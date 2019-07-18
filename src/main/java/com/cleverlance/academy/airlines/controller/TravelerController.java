package com.cleverlance.academy.airlines.controller;

import com.cleverlance.academy.airlines.model.Traveler;
import com.cleverlance.academy.airlines.service.TravelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TravelerController
{
    @Autowired
    private TravelerService travelerService;

    @RequestMapping(path = "/travelers", method = RequestMethod.GET)
    public List<Traveler> getAllTravelers()
    {
        return travelerService.getAllTravelers();
    }

    @RequestMapping(path = "/travelers", method = RequestMethod.POST)
    public void createTraveler(@RequestBody Traveler traveler)
    {
        travelerService.createTraveler(traveler);
    }

    @RequestMapping(path = "/travelers/{id}", method = RequestMethod.GET)
    public Traveler getTravelerById(@PathVariable Long id)
    {
        final Optional<Traveler> found = travelerService.getTravelerById(id);
        return (found.orElse(null));
    }

}
