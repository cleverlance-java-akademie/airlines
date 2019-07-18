package com.cleverlance.academy.airlines.controllers;

import com.cleverlance.academy.airlines.model.Ticket;
import com.cleverlance.academy.airlines.repository.TicketsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerController {

    @Autowired
    TicketsRepo ticketsRepo;

    @RequestMapping(path = "/ticket", method = RequestMethod.POST)//mark as sold and add traveller id
    public void sellTicket(@RequestBody Ticket ticket, Long flightId, Long travellerId) {

        ticketsRepo.getOne(ticket.getTicketId());
    }

}
