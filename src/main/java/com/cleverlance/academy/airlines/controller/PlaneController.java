package com.cleverlance.academy.airlines.controller;

import com.cleverlance.academy.airlines.model.Plane;
import com.cleverlance.academy.airlines.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping(path = "/planes/{registrationCode}", method = RequestMethod.GET)
    public Plane getPlaneByRegistrationCode(@PathVariable("registrationCode") String registrationCode)
    {
        Optional<Plane> plane = planeService.getPlaneByRegistrationCode(registrationCode);
        return (plane.isPresent() ? plane.get() : null);
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
