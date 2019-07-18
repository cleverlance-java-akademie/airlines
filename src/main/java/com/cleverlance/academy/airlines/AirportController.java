package com.cleverlance.academy.airlines;


import com.cleverlance.academy.airlines.client.IAirportService;
import com.cleverlance.academy.airlines.model.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirportController {

    @Autowired
    private IAirportService IAirportService;

    @RequestMapping(path="/airports", method = RequestMethod.GET)
    public List<Destination> getAirports(){return IAirportService.getAllAirports();
    }
}
