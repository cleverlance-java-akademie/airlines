package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entity.Ticket;

import java.util.List;

public interface ITicketService {

    void createTicket (final Ticket ticket);
    List<Ticket> getAllTickets ();
}
