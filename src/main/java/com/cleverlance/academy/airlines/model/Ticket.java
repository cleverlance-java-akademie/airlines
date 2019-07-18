package com.cleverlance.academy.airlines.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class Ticket {

    @Id
    @GeneratedValue
    private Long ticketId;

    private Double price;

    private FlightClass flightClass;

    private String seat;

    private TicketStatus ticketStatus;

    @ManyToOne
    private Traveler traveler;

    @ManyToOne
    private Flight flight;
}
