package com.cleverlance.academy.airlines.controller;

import com.cleverlance.academy.airlines.entities.Destination;
import com.cleverlance.academy.airlines.entities.Flight;
import com.cleverlance.academy.airlines.entities.Passenger;
import com.cleverlance.academy.airlines.entities.Ticket;
import com.cleverlance.academy.airlines.repositories.DestinationRepository;
import com.cleverlance.academy.airlines.repositories.FlightRepository;
import com.cleverlance.academy.airlines.repositories.PassengerRepository;
import com.cleverlance.academy.airlines.service.TicketService;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping(path = "/tickets", method = RequestMethod.GET)
    public List<Ticket> listAllTickets(){
        return ticketService.getAllTickets();
    }

    @RequestMapping(path = "/tickets/buy", method = RequestMethod.POST)
    public int buyTicket(@RequestParam long flightID,@RequestParam long passengerID){
        return ticketService.buyTicket(flightID,passengerID);
    }


//    //TODO: TOHLE JE ZPRASENA INICIALIZACE, PROTOZE SE BLIZI OBED
//    Destination praha = Destination.builder().name("Prague").code("PRG").build();
//    Destination brno = Destination.builder().name("Brno").code("BRNO").build();
//    Flight let1 = Flight.builder().start(praha).end(brno).build();
//    Passenger passenger = Passenger.builder().firstName("Ondrej").lastName("Sofr").build();
//
//    @Autowired
//    private FlightRepository flightRepository;
//
//    @Autowired
//    private PassengerRepository passengerRepository;
//
//    @Autowired
//    private DestinationRepository destinationRepository;
//
//
//
//
//    @RequestMapping(path = "/tickets/init", method = RequestMethod.GET)
//    public void initPrase(){
//        destinationRepository.saveAndFlush(praha);
//        destinationRepository.saveAndFlush(brno);
//        passengerRepository.saveAndFlush(passenger);
//        flightRepository.saveAndFlush(let1);
//    }


}
