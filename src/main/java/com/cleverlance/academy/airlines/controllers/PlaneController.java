package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.model.Plane;
import com.cleverlance.academy.airlines.service.IHangarService;
import com.cleverlance.academy.airlines.service.IPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlaneController {

    @Autowired
    private IPlaneService planeService;

    @Autowired
    private IHangarService hangarService;

    @RequestMapping(path = "/planes", method = RequestMethod.GET)
    public List<Plane> getPlanes() {
        return planeService.getAllPlanes();
    }

    @RequestMapping(path = "/planes", method = RequestMethod.DELETE)
    public void deletePlane(@RequestBody Plane plane) {
        planeService.deletePlane(plane.getId());
    }

    @RequestMapping(path = "/planes", method = RequestMethod.PUT)
    public void updatePlane(@RequestBody Plane plane) {
        planeService.updatePlane(plane);
    }

    @RequestMapping(path = "/planes", method = RequestMethod.POST)
    public void createPlane(@RequestBody Plane plane) {
        planeService.updatePlane(plane);
    }

    @RequestMapping(path = "/planes/{registrationCode}", method = RequestMethod.GET)
    public Plane getPlaneByRegCode(@PathVariable("regCode") String code) {
        Optional<Plane> plane = planeService.getPlaneByRegCode(code);
        if (plane.isPresent()) return plane.get();
        return null;
//        return planeService.getPlaneByRegCode(code);
    }
}
