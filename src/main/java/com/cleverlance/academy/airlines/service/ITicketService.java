package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Ticket;

public interface ITicketService {

    void createTickets(String startDestinationCode, String finalDestinationCode, final long numberOfSeats);
}
