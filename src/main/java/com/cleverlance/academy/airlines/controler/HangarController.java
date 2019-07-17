package com.cleverlance.academy.airlines.controler;


import com.cleverlance.academy.airlines.entities.Hangar;
import com.cleverlance.academy.airlines.service.IHangarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HangarController {

    @Autowired
    private IHangarService hangarService;

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
}
