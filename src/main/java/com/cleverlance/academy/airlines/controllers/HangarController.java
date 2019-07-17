package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.model.Hangar;
import com.cleverlance.academy.airlines.model.Plane;
import com.cleverlance.academy.airlines.service.IHangarService;
import com.cleverlance.academy.airlines.service.IPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HangarController {

    @Autowired
    private IHangarService hangarService;

    @Autowired
    private IPlaneService planeService;

    @RequestMapping(path = "/hangars", method = RequestMethod.GET)
    public List<Hangar> getHangars() {
        return hangarService.getAll();
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.POST)
    public void createHangar(@RequestBody Hangar hangar) {
        hangarService.createHangar(hangar);
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.DELETE)
    public void deleteHangar(@RequestBody Hangar hangar) {
        hangarService.deleteHangar(hangar.getHangarId());
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.PUT)
    public void updateHangar(@RequestBody Hangar hangar) {
        hangarService.updateHangar(hangar);
    }

    @RequestMapping(path = "/hangards/{hangarId}/{plane}", method = RequestMethod.PUT)
    public void parkPlaneToHangar(@PathVariable("hangarId") Long hangarId,
                                  @PathVariable("plane") Long planeId) {
        final Optional<Hangar> hangar = hangarService.getHangarById(hangarId);
        final Optional<Plane> plane = planeService.getPlaneById(planeId);
        if (hangar.isPresent() && plane.isPresent()) {
            hangarService.addPlaneToHangar(hangar.get(), plane.get());
        }
    }
}
