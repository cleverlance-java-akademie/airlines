package com.cleverlance.academy.airlines.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Airplane {
    private String registrationSign;
    private int seatsEconomy;
    private int seatsPremium;

    @Id
    @GeneratedValue
    private long id;

}
