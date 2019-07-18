package com.cleverlance.academy.airlines.controller;


import com.cleverlance.academy.airlines.model.Ticket;
import com.cleverlance.academy.airlines.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private ITicketService service;

    @RequestMapping(path = "/ticket", method = RequestMethod.POST)
    public Ticket createTicket(@RequestBody Ticket ticket) {
        service.createTicket(ticket);
        return ticket;
    }

}
