package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Ticket;
import com.cleverlance.academy.airlines.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketService implements ITicketService {

    @Autowired
    private TicketRepository repo;

    @Override
    public Ticket createTicket(Ticket ticket) {
        repo.saveAndFlush(ticket);
        return ticket;
    }
}
