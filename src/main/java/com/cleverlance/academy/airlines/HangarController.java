package com.cleverlance.academy.airlines;

import com.cleverlance.academy.airlines.entities.Hangar;
import com.cleverlance.academy.airlines.entities.Plane;
import com.cleverlance.academy.airlines.service.HangarService;
import com.cleverlance.academy.airlines.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HangarController {
    @Autowired
    private HangarService hangars;

    @Autowired
    private PlaneService planes;

    @RequestMapping(path = "/hangars", method = RequestMethod.GET)
    public List<Hangar> getPlanes(){
        return hangars.getAllHangars();
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.POST)
    public void postPlane(@RequestBody Hangar hangar){
        hangars.createHangar(hangar);
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.PUT)
    public void putPlane(@RequestBody Hangar hangar){
        hangars.updateHangar(hangar);
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.DELETE)
    public void deletePlane(@RequestParam int id){
        hangars.deleteHangar(id);
    }

    @RequestMapping(path = "/hangars/{hangarId}/{planeId}", method = RequestMethod.PUT)
    public void parkPlane(@PathVariable("hangarId") int hangarId, @PathVariable("planeId") int planeId){
        final Optional<Hangar> hangar = hangars.getHangarById(hangarId);
        final Optional<Plane> plane = planes.getPlane(planeId);
        if (hangar.isPresent() && plane.isPresent()){
            hangars.addPlane(hangar.get(), plane.get());
        }
    }
}
