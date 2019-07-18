package com.cleverlance.academy.airlines.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private ClassEnum flightClass;
    private int seat;
    private Status status;
    @ManyToOne
    private Flight flight;
    @ManyToOne
    private Traveler traveler;



}
