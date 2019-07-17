package com.cleverlance.academy.airlines.controler;


import com.cleverlance.academy.airlines.entities.Airplane;
import com.cleverlance.academy.airlines.entities.Hangar;
import com.cleverlance.academy.airlines.service.IAirplaneService;
import com.cleverlance.academy.airlines.service.IHangarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HangarController {

    @Autowired
    private IHangarService hangarService;

    @Autowired
    private IAirplaneService airplaneService;

    @RequestMapping(path = "/hangars", method = RequestMethod.GET)
    public List<Hangar> listAllHangars(){
        return hangarService.getAllHangars();
    }


    @RequestMapping(path = "/hangars", method = RequestMethod.POST)
    public void createHangar(@RequestBody Hangar hangar){
        this.hangarService.addHangar(hangar);
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.PUT)
    public void updateHangar(@RequestBody Hangar hangar){
        this.hangarService.updateHangar(hangar);

        //return new HttpResponse();
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.DELETE)
    public void deleteHangar(@RequestParam long Id){
        this.hangarService.deleteHangar(Id);
    }

    @RequestMapping(path = "/hangars/{hangarId}/{airplaneId}", method = RequestMethod.PUT)
    public void addAirplaneIntoHangar(@PathVariable("hangarId") long hangarId,
                                      @PathVariable("airplaneId") long airplaneId){
        Optional<Hangar> hangar = hangarService.getHangarById(hangarId);
        Optional<Airplane> airplane = airplaneService.getAirplaneById(airplaneId);
        this.hangarService.addAirplaneToHangar(hangar.get(),airplane.get());

        //return new HttpResponse();
    }
}
