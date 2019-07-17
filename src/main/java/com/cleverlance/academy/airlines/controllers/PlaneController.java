package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.entities.Hangar;
import com.cleverlance.academy.airlines.servicies.IHangarService;
import com.cleverlance.academy.airlines.servicies.IPlaneService;
import com.cleverlance.academy.airlines.entities.Airplane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlaneController {

    @Autowired
    private IPlaneService planeService;

    @RequestMapping(value = "/planes", method = RequestMethod.GET)
    public List<Airplane> getPlanes(){
        return planeService.getAllAirplanes();

    }

    @RequestMapping(path = "/planes/{registrationCode}", method = RequestMethod.GET)
    public Airplane getPlaneByCode(@PathVariable("registrationCode") String code){

        Optional<Airplane> plane = planeService.getPlaneByCode(code);
        if(plane.isPresent()){
            return plane.get();
        }
        return null;
    }

    @RequestMapping(value = "/planes", method = RequestMethod.POST)
    public void createPlanes(@RequestBody Airplane aP){
        planeService.createPlane(aP);

    }
    @RequestMapping(value = "/planes", method = RequestMethod.DELETE)
    public void deletePlanes(@RequestBody Airplane aP){
        planeService.deletePlane(aP.getId());

    }
    @RequestMapping(value = "/planes", method = RequestMethod.PUT)
    public void updatePlanes(@RequestBody Airplane aP){
        planeService.updatePlane(aP);

    }


}
