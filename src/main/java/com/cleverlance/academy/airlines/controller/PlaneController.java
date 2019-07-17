package com.cleverlance.academy.airlines.controller;

import com.cleverlance.academy.airlines.model.Plane;
import com.cleverlance.academy.airlines.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaneController
{
    @Autowired
    private PlaneService planeService;

    @RequestMapping(path = "/planes", method = RequestMethod.GET)
    public List<Plane> get()
    {
        return planeService.getAllPlanes();
    }

    @RequestMapping(path = "/planes", method = RequestMethod.PUT)
    public void update(@RequestBody Plane plane)
    {
        planeService.updatePlane(plane);
    }

    @RequestMapping(path = "/planes", method = RequestMethod.DELETE)
    public void delete(@RequestBody Plane plane)
    {
        planeService.deletePlane(plane.getId());
    }

    @RequestMapping(path = "/planes", method = RequestMethod.POST)
    public void create(@RequestBody Plane plane)
    {
        planeService.createPlane(plane);
    }
}
