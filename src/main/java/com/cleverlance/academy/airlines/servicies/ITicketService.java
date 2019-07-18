package com.cleverlance.academy.airlines.servicies;

import com.cleverlance.academy.airlines.entities.Flight;
import com.cleverlance.academy.airlines.entities.Ticket;
import com.cleverlance.academy.airlines.entities.Traveler;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ITicketService {

    List<Ticket> getAllTickets();

    void createTicket(Long traveler, Long flight);

    void updateTicket(Ticket t);
}
