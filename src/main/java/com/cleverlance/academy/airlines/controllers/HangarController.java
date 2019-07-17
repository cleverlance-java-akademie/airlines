package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.model.Hangar;
import com.cleverlance.academy.airlines.service.IHangarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HangarController {

    @Autowired
    private IHangarService hangarService;

    @RequestMapping(path = "/hangars", method = RequestMethod.GET)
    public List<Hangar> getHangars() {
        return hangarService.getAll();
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.POST)
    public void createHangar(@RequestBody Hangar hangar) {
        hangarService.createHangar(hangar);
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.DELETE)
    public void deleteHangar(@RequestBody Hangar hangar) {
        hangarService.deleteHangar(hangar.getHangarId());
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.PUT)
    public void updateHangar(@RequestBody Hangar hangar) {
        hangarService.updateHangar(hangar);
    }
}
