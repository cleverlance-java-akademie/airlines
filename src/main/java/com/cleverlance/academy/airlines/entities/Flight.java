package com.cleverlance.academy.airlines.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flight {

    @Id
    @GeneratedValue
    private long flightId;

    private String code;

    private ZonedDateTime date;

    @ManyToOne
    private Destination end;

    @ManyToOne
    private Destination start;

    @OneToMany
    private List<Ticket> tickets;
}
