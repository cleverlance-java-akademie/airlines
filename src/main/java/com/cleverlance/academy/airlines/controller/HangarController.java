package com.cleverlance.academy.airlines.controller;

import com.cleverlance.academy.airlines.model.Hangar;
import com.cleverlance.academy.airlines.service.HangarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HangarController
{
    @Autowired
    private HangarService hangarService;

    @RequestMapping(path = "/hangars", method = RequestMethod.GET)
    public List<Hangar> get()
    {
        return hangarService.getAllHangars();
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.POST)
    public void post(@RequestBody Hangar hangar)
    {
        hangarService.update(hangar);
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.DELETE)
    public void delete(@RequestBody Hangar hangar)
    {
        hangarService.deleteHangar(hangar.getHangarId());
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.PUT)
    public void create(@RequestBody Hangar hangar)
    {
        hangarService.createHangar(hangar);
    }
}
