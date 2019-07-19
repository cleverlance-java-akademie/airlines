package com.cleverlance.academy.airlines.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @GeneratedValue
    @Id
    private Long flightId;

    private String code;

    private ZonedDateTime date;

    @ManyToOne
    private Destination start;

    @ManyToOne
    private Destination end;

    @OneToMany
    private List<Ticket> tickets;
}