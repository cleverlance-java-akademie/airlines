package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Ticket;
import com.cleverlance.academy.airlines.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private FlightService flightService;

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public void delete(final Long aLong) {
        ticketRepository.deleteById(aLong);
    }

    @Override
    public void update(final Ticket e) {
        ticketRepository.save(e);
    }

    @Override
    public void create(final Ticket e) {
        ticketRepository.save(e);
    }

    @Override
    public Optional<Ticket> getById(final Long id) {
        return ticketRepository.findById(id);
    }

//    @PostConstruct
//    private void initIfEmpty() {
//        long count = ticketRepository.count();
//        if (count == 0)
//
//    }
//
//    private Ticket createRandomTicket() {
//        List<Flight> persistedFlights = flightService.getAll();
//        return Ticket.builder()
//                .flight(persistedFlights.)
//    }
}
