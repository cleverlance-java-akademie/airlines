package com.cleverlance.academy.airlines.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket {

    @Id
    @GeneratedValue
    private Long ticketId;

    private Double price;
    private ClassEnum flightClass;
    private int seat;
    private Status status;
    @ManyToOne
    private Flight flight;
    @ManyToOne
    private Traveler traveler;



}
