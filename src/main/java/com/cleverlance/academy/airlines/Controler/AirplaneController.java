package com.cleverlance.academy.airlines.Controler;

import com.cleverlance.academy.airlines.entities.Airplane;
import com.cleverlance.academy.airlines.repositories.AirplaneRepository;
import com.cleverlance.academy.airlines.service.IAirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

@RestController
public class AirplaneController {

    @Autowired
    private IAirplaneService airplaneService;

    @RequestMapping(path = "/airplanes", method = RequestMethod.GET)
    public List<Airplane> listAllAirplanes(){
        return airplaneService.getAllPlanes();
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
