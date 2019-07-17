package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.Servicies.IPlaneService;
import com.cleverlance.academy.airlines.entities.Airplane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private IPlaneService planeService;

    @RequestMapping(value = "/planes", method = RequestMethod.GET)
    public List<Airplane> getPlanes(){
        return planeService.getAllAirplanes();

    }
    @RequestMapping(value = "/planes", method = RequestMethod.POST)
    public void createPlanes(@RequestBody Airplane ap){
        planeService.createPlane(ap);

    }
    @RequestMapping(value = "/planes", method = RequestMethod.DELETE)
    public void deletePlanes(@RequestBody Airplane aP){
        planeService.deletePlane(aP.getId());

    }
    @RequestMapping(value = "/planes", method = RequestMethod.PUT)
    public void updatePlanes(@RequestBody Airplane aP){
        planeService.updatePlane(aP.getId(), aP);

    }
}
