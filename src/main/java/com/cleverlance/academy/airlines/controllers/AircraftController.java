package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.Service.AircraftService;
import com.cleverlance.academy.airlines.entity.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    @RequestMapping(path = "/planes", method = RequestMethod.GET)
    public List<Aircraft> getPlane(){
        return aircraftService.getAllPlanes();
    }
    @RequestMapping(path = "/planes", method = RequestMethod.POST)
    public void createPlane(@RequestBody Aircraft aircraft){
        aircraftService.createPlane(aircraft);
    }
    @RequestMapping(path = "/planes{id}", method = RequestMethod.DELETE)
    public void deletePlane(@RequestParam int id){
        aircraftService.deletePlane(id);
    }

    @RequestMapping(path = "/planes", method = RequestMethod.PUT)
    public void updatePlane(@RequestBody Aircraft aircraft){
        aircraftService.updatePlane(aircraft);
    }
}
