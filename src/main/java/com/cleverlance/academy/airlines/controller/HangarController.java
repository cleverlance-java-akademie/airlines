package com.cleverlance.academy.airlines.controller;

import com.cleverlance.academy.airlines.model.Airplane;
import com.cleverlance.academy.airlines.model.Hangar;
import com.cleverlance.academy.airlines.service.IAirplanesService;
import com.cleverlance.academy.airlines.service.IHangarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class HangarController {

    @Autowired
    private IHangarService service;

    @Autowired
    private IAirplanesService airplaneService;

    @RequestMapping(path = "/hangars", method = RequestMethod.GET)
    public List<Hangar> getHangars() {
        return service.getAllHangars();
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.POST)
    public ResponseEntity addHangar(@RequestParam Long id, @RequestParam String name) {
        service.addHangar(new Hangar(id, name, new ArrayList<>()));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/hangars", method = RequestMethod.DELETE)
    public ResponseEntity removeHangar(int id) {
        service.removeHangar(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/hangar/{hangarId}/{airplaneId}", method = RequestMethod.PUT)
    public void parkAirplaneToHangar(@PathVariable("hangarId") int hangarId, @PathVariable("airplaneId") int airplaneId) {
        final Optional<Hangar> hangar = service.getHangarById(hangarId);
        final Optional<Airplane> airplane = airplaneService.getAirplaneById(airplaneId);
        if (hangar.isPresent() && airplane.isPresent()) {
            service.parkAirplaneTiHangar(hangar.get(), airplane.get());
        }
    }
}
