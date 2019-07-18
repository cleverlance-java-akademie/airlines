package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.entity.Aircraft;
import com.cleverlance.academy.airlines.entity.Ticket;
import com.cleverlance.academy.airlines.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @RequestMapping(path = "/tickets", method = RequestMethod.POST)
    public void createTicket(@RequestBody Ticket ticket){
        ticketService.createTicket(ticket);
    }

    @RequestMapping(path = "/tickets", method = RequestMethod.GET)
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }
}
