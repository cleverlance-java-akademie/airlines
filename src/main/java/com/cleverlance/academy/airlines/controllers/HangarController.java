package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.servicies.IHangarService;
import com.cleverlance.academy.airlines.entities.Hangar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HangarController {

    @Autowired
    private IHangarService hangarSevice;

    @RequestMapping(value = "/hangars", method = RequestMethod.GET)
    public List<Hangar> getHangars(){
        return hangarSevice.getAllHangars();

    }
    @RequestMapping(value = "/hangars", method = RequestMethod.POST)
    public void createHangar(@RequestBody Hangar h){
        hangarSevice.createHangar(h);

    }
    @RequestMapping(value = "/hangars", method = RequestMethod.DELETE)
    public void deleteHangar(@RequestBody Hangar h){
        hangarSevice.deleteHangar(h.getId());

    }
    @RequestMapping(value = "/hangars", method = RequestMethod.PUT)
    public void updateHangar(@RequestBody Hangar h){
        hangarSevice.updateHangar(h);

    }
}
