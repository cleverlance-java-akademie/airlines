package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.entity.Aircraft;
import com.cleverlance.academy.airlines.service.AircraftService;
import com.cleverlance.academy.airlines.service.GarageService;
import com.cleverlance.academy.airlines.entity.Garage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GarageController {

    @Autowired
    private GarageService garageService;

    @Autowired
    private AircraftService aircraftService;

    @RequestMapping(path = "/garages", method = RequestMethod.GET)
    public List<Garage> getGarage(){
        return garageService.getAllGarages();
    }
    @RequestMapping(path = "/garages", method = RequestMethod.POST)
    public void createGarage(@RequestBody Garage garage){
        garageService.createGarage(garage);
    }
    @RequestMapping(path = "/garages{id}", method = RequestMethod.DELETE)
    public void deleteGarage(@RequestParam int id){
        garageService.deleteGarage(id);
    }
    @RequestMapping(path = "/garages", method = RequestMethod.PUT)
    public void updateGarage(@RequestBody Garage garage){
        garageService.updateGarage(garage);
    }
    @RequestMapping(path = "/garages/{garageId}/{planeId}", method = RequestMethod.PUT)
    public void parkPlaneToGarage(@PathVariable("garageId")int garageId,@PathVariable("planeId")int planeId){
        final Optional<Garage> garage = garageService.getGarageById(garageId);
        final Optional<Aircraft> aircraft = aircraftService.getAircraftById(planeId);
        garageService.addPlaneToGarage(garage.get(),aircraft.get());
    }
}
