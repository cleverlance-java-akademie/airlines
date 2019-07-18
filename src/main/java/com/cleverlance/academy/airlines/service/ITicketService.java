package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entities.Ticket;

import java.util.List;

public interface ITicketService {

    List<Ticket> getAllTickets();

    int buyTicket(long flightID, long passengerID);
}
