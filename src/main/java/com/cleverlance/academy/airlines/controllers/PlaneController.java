package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.entities.Hangar;
import com.cleverlance.academy.airlines.servicies.IHangarService;
import com.cleverlance.academy.airlines.servicies.IPlaneService;
import com.cleverlance.academy.airlines.entities.Airplane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaneController {

    @Autowired
    private IHangarService hangarService;

    @RequestMapping(value = "/planes", method = RequestMethod.GET)
    public List<Hangar> getPlanes(){
        return hangarService.getAllHangars();

    }
    @RequestMapping(value = "/planes", method = RequestMethod.POST)
    public void createPlanes(@RequestBody Hangar h){
        hangarService.createHangar(h);

    }
    @RequestMapping(value = "/planes", method = RequestMethod.DELETE)
    public void deletePlanes(@RequestBody Hangar h){
        hangarService.deleteHangar(h.getId());

    }
    @RequestMapping(value = "/planes", method = RequestMethod.PUT)
    public void updatePlanes(@RequestBody Hangar h){
        hangarService.updateHangar(h);

    }
}
