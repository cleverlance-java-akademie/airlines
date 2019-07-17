package com.cleverlance.academy.airlines.controller;

import com.cleverlance.academy.airlines.model.Hangar;
import com.cleverlance.academy.airlines.service.IHangarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HangarController {

    @Autowired
    private IHangarService service;

    @RequestMapping(path = "/hangars", method = RequestMethod.GET)
    public List<Hangar> getHangars() {
        return service.getAllHangars();
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.POST)
    public ResponseEntity addHangar(@RequestParam int id, @RequestParam String name) {
        service.addHangar(new Hangar(id, name));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.DELETE)
    public ResponseEntity removeHangar(int id) {
        service.removeHangar(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
