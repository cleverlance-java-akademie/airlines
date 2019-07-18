package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.entity.Flight;
import com.cleverlance.academy.airlines.entity.Ticket;
import com.cleverlance.academy.airlines.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {

    @Autowired
    FlightService flightService;

    @RequestMapping(path = "/flights", method = RequestMethod.POST)
    public void createTicket(@RequestBody Flight flight){
        flightService.createFlight(flight);
    }

}
