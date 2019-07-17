package com.cleverlance.academy.airlines;

import com.cleverlance.academy.airlines.entities.Hangar;
import com.cleverlance.academy.airlines.service.HangarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HangarController {
    @Autowired
    private HangarService hangars;

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
}
