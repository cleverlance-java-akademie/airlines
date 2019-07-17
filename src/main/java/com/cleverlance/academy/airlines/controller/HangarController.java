package com.cleverlance.academy.airlines.controller;

import com.cleverlance.academy.airlines.model.Hangar;
import com.cleverlance.academy.airlines.model.Plane;
import com.cleverlance.academy.airlines.service.HangarService;
import com.cleverlance.academy.airlines.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HangarController
{
    @Autowired
    private HangarService hangarService;

    @Autowired
    private PlaneService planeService;

    @RequestMapping(path = "/hangars", method = RequestMethod.GET)
    public List<Hangar> get()
    {
        return hangarService.getAllHangars();
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.PUT)
    public void update(@RequestBody Hangar hangar)
    {
        hangarService.update(hangar);
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.DELETE)
    public void delete(@RequestBody Hangar hangar)
    {
        hangarService.deleteHangar(hangar.getHangarId());
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.POST)
    public void create(@RequestBody Hangar hangar)
    {
        hangarService.createHangar(hangar);
    }

    @RequestMapping(path = "/hangars/{hangarId}/{planeId}", method = RequestMethod.PUT)
    public void parkPlaneToHangar(@PathVariable("hangarId") Long hangarId, @PathVariable("planeId") Long planeId)
    {
        final Optional<Hangar> hangar = hangarService.getHangarById(hangarId);
        final Optional<Plane> plane = planeService.getPlaneById(planeId);
        if (hangar.isPresent() && plane.isPresent())
        {
            hangarService.addPlaneToHangar(hangar.get(), plane.get());
        }
    }
}
