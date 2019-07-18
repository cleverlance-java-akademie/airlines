package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.model.Flight;
import com.cleverlance.academy.airlines.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    FlightService flightService;

    @RequestMapping(path = "/flights", method = RequestMethod.GET)
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @RequestMapping(path = "/flights", method = RequestMethod.POST)
    public void createFligth(@RequestBody Flight flight) {
        flightService.createFlight(flight);
    }

    @RequestMapping(path = "/flights", method = RequestMethod.PUT)
    public void updateFligth(@RequestBody Flight flight) {
        flightService.updateFlight(flight);
    }

    @RequestMapping(path = "/flights", method = RequestMethod.DELETE)
    public void deleteFligth(@RequestBody Long flightId) {
        flightService.deleteFlight(flightId);
    }


}
