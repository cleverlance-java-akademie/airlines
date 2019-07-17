package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.Service.GarageService;
import com.cleverlance.academy.airlines.entity.Aircraft;
import com.cleverlance.academy.airlines.entity.Garage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GarageController {

    @Autowired
    private GarageService garageService;

    @RequestMapping(path = "/garages", method = RequestMethod.GET)
    public List<Garage> getPlane(){
        return garageService.getAllGarages();
    }
    @RequestMapping(path = "/garages", method = RequestMethod.POST)
    public void createPlane(@RequestBody Garage garage){
        garageService.createGarage(garage);
    }
    @RequestMapping(path = "/garages{id}", method = RequestMethod.DELETE)
    public void deletePlane(@RequestParam int id){
        garageService.deleteGarage(id);
    }

    @RequestMapping(path = "/garages", method = RequestMethod.PUT)
    public void updatePlane(@RequestBody Garage garage){
        garageService.updateGarage(garage);
    }
}
