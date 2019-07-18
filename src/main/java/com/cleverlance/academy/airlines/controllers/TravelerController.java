package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.entity.Ticket;
import com.cleverlance.academy.airlines.entity.Traveler;
import com.cleverlance.academy.airlines.service.TravelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelerController {

    @Autowired
    TravelerService travelerService;

    @RequestMapping(path = "/travelers", method = RequestMethod.POST)
    public void createTraveler(@RequestBody Traveler traveler){
        travelerService.createTraveler(traveler);
    }

}
