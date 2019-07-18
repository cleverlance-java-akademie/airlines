package com.cleverlance.academy.airlines.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Flight {

    @Id
    @GeneratedValue
    private Long flightId;

    private String code;
    private ZonedDateTime date;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Destination start;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Destination end;
    @OneToMany
    private List<Ticket> tickets;
}
