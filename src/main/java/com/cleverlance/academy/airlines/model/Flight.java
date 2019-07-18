package com.cleverlance.academy.airlines.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flight {

    @Id
    @GeneratedValue

    private Long flightId;

    private String code;

    @ManyToOne
    private Destination start;

    @ManyToOne
    private Destination end;

    private ZonedDateTime date;

    @OneToMany
    private List<Ticket> tickets;
}
