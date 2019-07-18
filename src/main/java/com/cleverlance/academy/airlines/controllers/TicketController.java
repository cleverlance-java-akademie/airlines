package com.cleverlance.academy.airlines.controllers;


import com.cleverlance.academy.airlines.entities.Destination;
import com.cleverlance.academy.airlines.entities.Flight;
import com.cleverlance.academy.airlines.entities.Ticket;
import com.cleverlance.academy.airlines.entities.Traveler;
import com.cleverlance.academy.airlines.repository.FlightRepository;
import com.cleverlance.academy.airlines.repository.TravelerRepository;
import com.cleverlance.academy.airlines.servicies.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private FlightRepository fR;

    @Autowired
    private TravelerRepository tR;

    @Autowired
    private ITicketService tS;


    @RequestMapping(value = "/tickets/init", method = RequestMethod.PUT)
    public void init(){

        Destination start = Destination.builder().name("Praha").build();
        Destination end =  Destination.builder().name("Moskva").build();
        Flight f = Flight.builder().start(start).end(end).build();
        Traveler t = Traveler.builder().firstName("Alois").lastName("Kolomaz").build();

        fR.saveAndFlush(f);
        tR.saveAndFlush(t);

    }

    @RequestMapping(value = "/tickets/{flightId}/{travelerId}", method = RequestMethod.POST)
    public void createTicket(@PathVariable("flightId") Long fId, @PathVariable("travelerId") Long tId){

        tS.createTicket(tId,fId);
    }
}
