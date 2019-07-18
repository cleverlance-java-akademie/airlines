package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Ticket;

import java.util.Optional;

public interface ITicketService
{
    Optional<Ticket> getTicket(Long id);

    Ticket createTicket(Ticket ticket);

}
