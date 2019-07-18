package com.cleverlance.academy.airlines.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Flight {

    @Id
    @GeneratedValue
    private long flightId;

    private String code;
    private ZonedDateTime date;

    @ManyToOne
    private Destination start;

    @ManyToOne
    private Destination end;

    @OneToMany
    private List<Ticket> tickets;
}
