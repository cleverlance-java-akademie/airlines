package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.client.IAirportService;
import com.cleverlance.academy.airlines.model.Ticket;
import com.cleverlance.academy.airlines.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private IAirportService IAirportService;

    @Override
    public void createFlight(final String startDestinationCode, final String finalDestinationCode, final long numberOfSeats);{
    long numberOfEachClassSeats = numberOfSeats/3;
    char seatRow;
        for(seatRow='A'; seatRow<='F'; seatRow++)
        {
        createTicket
        }


    }

    @Override
    public void createTicket(final Ticket ticket) {ticketRepository.saveAndFlush(ticket);}

}
