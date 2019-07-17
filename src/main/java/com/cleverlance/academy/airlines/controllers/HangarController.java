package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.entities.Airplane;
import com.cleverlance.academy.airlines.servicies.IHangarService;
import com.cleverlance.academy.airlines.entities.Hangar;
import com.cleverlance.academy.airlines.servicies.IPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HangarController {

    @Autowired
    private IHangarService hangarSevice;

    @Autowired
    private IPlaneService planeService;

    @RequestMapping(value = "/hangars", method = RequestMethod.GET)
    public List<Hangar> getHangars(){
        return hangarSevice.getAllHangars();

    }
    @RequestMapping(value = "/hangars", method = RequestMethod.POST)
    public void createHangar(@RequestBody Hangar h){
        hangarSevice.createHangar(h);

    }
    @RequestMapping(value = "/hangars", method = RequestMethod.DELETE)
    public void deleteHangar(@RequestBody Hangar h){
        hangarSevice.deleteHangar(h.getId());

    }
    @RequestMapping(value = "/hangars", method = RequestMethod.PUT)
    public void updateHangar(@RequestBody Hangar h){
        hangarSevice.updateHangar(h);

    }

    @RequestMapping(value = "/hangars/{hangarId}/{planeId}", method = RequestMethod.PUT)
    public void parkPlaneToHangar(@PathVariable("hangarId") Long hanId, @PathVariable("planeId") Long planeId) {

        final Optional<Hangar> hangar = hangarSevice.getHangarById(hanId);
        final Optional<Airplane> plane = planeService.getPlaneById(planeId);
        if (hangar.isPresent() && plane.isPresent()) {

            hangarSevice.addPlaneToHangar(hangar.get(), plane.get());
        }
    }
}
