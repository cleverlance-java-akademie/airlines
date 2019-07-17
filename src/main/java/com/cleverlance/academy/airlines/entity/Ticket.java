package com.cleverlance.academy.airlines.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket {

    @Id
    @GeneratedValue
    private Long ticketId;
    private Double price;
    private FlighClass flighClass;
    private String seat;
    private TicketStatus ticketStatus;
    @ManyToOne
    private Flight flight;
    @ManyToOne
    private Traveler traveler;

}
