package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Ticket;
import com.cleverlance.academy.airlines.repository.TicketsRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SellerService implements ISellerService {

    @Autowired
    private TicketsRepo repo;

    @Override
    public void createTicket(final Ticket ticket) {
        repo.saveAndFlush(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return repo.findAll();
    }

    @Override
    public void updateTicket(final Ticket ticket) {
        repo.saveAndFlush(ticket);
    }

    @Override
    public void deleteTicket(final Long ticketId) {
        repo.delete(this.repo.getOne(ticketId));
    }

    @Override
    public Ticket sellTicket() {
        return null;
    }
}
