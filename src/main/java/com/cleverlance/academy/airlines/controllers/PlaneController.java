package com.cleverlance.academy.airlines;

import com.cleverlance.academy.airlines.model.Plane;
import com.cleverlance.academy.airlines.service.IPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlaneController {

    @Autowired
    private IPlaneService planeService;

    @RequestMapping(path = "/planes", method = RequestMethod.GET)
    public List<Plane> getPlanes() {
        return planeService.getAllPlanes();
    }

    @RequestMapping(path = "/planes", method = RequestMethod.POST)
    public void createPlane(@RequestBody Plane plane) {
        planeService.createPlane(plane);
    }

    @RequestMapping(path = "/planes", method = RequestMethod.DELETE)
    public void deletePlane(@RequestBody Plane plane) {
        planeService.deletePlane(plane.getId());
    }

    @RequestMapping(path = "/planes", method = RequestMethod.PUT)
    public void updatePlane(@RequestBody Plane plane) {
        planeService.updatePlane(plane);
    }

    @RequestMapping(path = "/planes/{registrationCode}", method = RequestMethod.GET)
    public Plane getPlaneByRegistrationCode(@PathVariable("registrationCode") String registrationCode) {
        final Optional<Plane> plane =
                planeService.getPlaneByRegistrationCode(registrationCode);
        if(plane.isPresent())
            return plane.get();
        return null;
    }
}
