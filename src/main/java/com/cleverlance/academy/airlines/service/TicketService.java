package com.cleverlance.academy.airlines.service;


import com.cleverlance.academy.airlines.entities.Flight;
import com.cleverlance.academy.airlines.entities.Passenger;
import com.cleverlance.academy.airlines.entities.Ticket;
import com.cleverlance.academy.airlines.repositories.FlightRepository;
import com.cleverlance.academy.airlines.repositories.PassengerRepository;
import com.cleverlance.academy.airlines.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements ITicketService{

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Ticket> getAllTickets() {
        return null;
    }

    @Override
    public int buyTicket(long flightID, long passengerID) {
        Optional<Flight> flight = flightRepository.findById(flightID);
        Optional<Passenger> passenger = passengerRepository.findById(passengerID);
        Ticket ticket = Ticket.builder().flight(flight.get()).passenger(passenger.get()).build();
        ticketRepository.saveAndFlush(ticket);
        return 0;
    }







}
