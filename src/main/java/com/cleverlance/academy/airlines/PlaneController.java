package com.cleverlance.academy.airlines;

import com.cleverlance.academy.airlines.entities.Plane;
import com.cleverlance.academy.airlines.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaneController {
    @Autowired
    private PlaneService planes;

    @RequestMapping(path = "/planes", method = RequestMethod.GET)
    public List<Plane> getPlanes(){
        return planes.getAllPlanes();
    }

    @RequestMapping(path = "/planes", method = RequestMethod.POST)
    public void postPlane(@RequestBody Plane plane){
        planes.createPlane(plane);
    }

    @RequestMapping(path = "/planes", method = RequestMethod.PUT)
    public void putPlane(@RequestBody Plane plane){
        planes.updatePlane(plane);
    }

    @RequestMapping(path = "/planes", method = RequestMethod.DELETE)
    public void deletePlane(@RequestParam int id){
        planes.deletePlane(id);
    }
}
