package com.cleverlance.academy.airlines.controller;

import com.cleverlance.academy.airlines.entities.Airplane;
import com.cleverlance.academy.airlines.mapper.AirplaneMapper;
import com.cleverlance.academy.airlines.mapper.AirportMapper;
import com.cleverlance.academy.airlines.service.IAirplaneService;
import generated.rest.api.AirplanesApi;
import generated.rest.model.AirplaneGen;
import generated.rest.model.AirplaneListGen;
import generated.restclient.model.AirportGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RestController
public class AirplaneController implements AirplanesApi {

    @Autowired
    private IAirplaneService airplaneService;

    @Autowired
    private AirplaneMapper airplaneMapper;

    @RequestMapping(path = "/airplanes", method = RequestMethod.GET)
    @Override
    public CompletableFuture<ResponseEntity<AirplaneListGen>> getPlanes(){
        List<Airplane> result = airplaneService.getAllPlanes();
        List<AirplaneGen> responseList = result.stream()
                .map(item -> airplaneMapper.convertToAirplaneGen(item))
                .collect(Collectors.toList());
        AirplaneListGen response = new AirplaneListGen();
        response.addAll(responseList);
        return new CompletableFuture.completedFuture(ResponseEntity.ok(response));
    }

    @RequestMapping(path = "/airplanes/{regCode}", method = RequestMethod.GET)
    public Airplane getAirplaneByCode(@PathVariable("regCode") String code){
        Optional<Airplane> airplane = airplaneService.getAirplaneByCode(code);
        if(airplane.isPresent()){
            return airplane.get();
        }
        return null;
    }


    @RequestMapping(path = "/airplanes", method = RequestMethod.POST)
    public void createAirplane(@RequestBody Airplane airplane){
        this.airplaneService.addPlane(airplane);
    }

    @RequestMapping(path = "/airplanes", method = RequestMethod.PUT)
    public void updateAirplane(@RequestBody Airplane airplane){
        this.airplaneService.updatePlane(airplane);

        //return new HttpResponse();
    }

    @RequestMapping(path = "/airplanes", method = RequestMethod.DELETE)
    public void deleteAirplane(@RequestParam long Id){
        this.airplaneService.deletePlane(Id);
    }



}
