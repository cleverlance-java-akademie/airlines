package com.cleverlance.academy.airlines.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aircraft {

    @Id
    @GeneratedValue
    private int id;

    private String registration;
    private int numOfSeatsFirstClass;
    private int numOfSeatsEconomyClass;


}
