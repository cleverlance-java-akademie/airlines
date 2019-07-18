package com.cleverlance.academy.airlines.model;

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
    private Long flightId;

    private String code;

    private ZonedDateTime dateTime;

    @ManyToOne
    private Destination end;

    @ManyToOne
    private Destination start;

    @OneToMany
    private List<Ticket> tickets;
}
