package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Ticket;

import java.util.List;

public interface ISellerService {

    void createTicket(Ticket ticket);

    List<Ticket> getAllTickets();

    void updateTicket(Ticket ticket);

    void deleteTicket(Long ticketId);

    Ticket sellTicket();
}
