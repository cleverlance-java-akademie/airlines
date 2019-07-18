package com.cleverlance.academy.airlines.controller;

import com.cleverlance.academy.airlines.model.Ticket;
import com.cleverlance.academy.airlines.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController
{
    @Autowired
    private TicketService ticketService;

    @RequestMapping(path = "tickets", method = RequestMethod.POST)
    public Ticket createTicket(@RequestBody Ticket ticket)
    {
        return ticketService.createTicket(ticket);
    }
}
