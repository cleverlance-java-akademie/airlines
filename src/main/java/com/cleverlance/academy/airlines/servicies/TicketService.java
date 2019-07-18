package com.cleverlance.academy.airlines.servicies;

import com.cleverlance.academy.airlines.entities.Flight;
import com.cleverlance.academy.airlines.entities.Ticket;
import com.cleverlance.academy.airlines.entities.Traveler;
import com.cleverlance.academy.airlines.repository.FlightRepository;
import com.cleverlance.academy.airlines.repository.TicketRepository;
import com.cleverlance.academy.airlines.repository.TravelerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private TicketRepository tSR;

    @Autowired
    private FlightRepository fR;

    @Autowired
    private TravelerRepository trR;

    @Autowired
    private TicketRepository tR;

    @Override
    public List<Ticket> getAllTickets() {
        return tSR.findAll();
    }

    @Override
    public void updateTicket(Ticket t) {

        tSR.saveAndFlush(t);
    }

    @Override
    public void createTicket(final Long trId, final Long fId) {

        Optional<Flight> flight = fR.findById(fId);
        Optional<Traveler> traveler = trR.findById(trId);
        Ticket ticket = new Ticket().builder().flight(flight.get()).traveler(traveler.get()).build();

        tR.saveAndFlush(ticket);


    }
}
