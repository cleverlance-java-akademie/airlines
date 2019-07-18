package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Ticket;
import com.cleverlance.academy.airlines.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService implements ITicketService
{
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Optional<Ticket> getTicket(final Long id)
    {
        return ticketRepository.findById(id);
    }

    @Override
    public Ticket createTicket(final Ticket ticket)
    {
        ticketRepository.saveAndFlush(ticket);
        return ticket;
    }
}
