package com.cleverlance.academy.airlines.controller;

import com.cleverlance.academy.airlines.model.Airplane;
import com.cleverlance.academy.airlines.service.IAirplanesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AirplanesController {

    @Autowired
    private IAirplanesService service;

    @RequestMapping(path = "/airplanes", method = RequestMethod.GET)
    public List<Airplane>  getAirplanes() {
        return service.getAirplanes();
    }

    @RequestMapping(path = "/airplanes/{registrationCode}", method = RequestMethod.GET)
    public Airplane getAirplaneByRegistrationCode(@PathVariable("registrationCode") String registrationCode) {
        final Optional<Airplane> airplane = service.getAirplaneByRegistrationCode(registrationCode);
        return airplane.orElse(null);
    }

    @RequestMapping(path = "/airplanes", method = RequestMethod.POST)
    public ResponseEntity addAirplane(@RequestParam int id, @RequestParam int first, @RequestParam int economy, @RequestParam String regPlate) {
        service.addAirplane(new Airplane(id, regPlate, first, economy));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/airplanes", method = RequestMethod.DELETE)
    public ResponseEntity removeAirplane(int id) {
        service.removeAirplane(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
