package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entity.Ticket;
import com.cleverlance.academy.airlines.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService {

    @Autowired
    TicketRepo ticketRepo;

    @Override
    public void createTicket(Ticket ticket) {
        ticketRepo.saveAndFlush(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }


}
