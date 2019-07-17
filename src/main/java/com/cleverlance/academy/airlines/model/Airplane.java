package com.cleverlance.academy.airlines.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Airplane {

    @Id
    @GeneratedValue
    private int id;
    private String regPlate;
    private int firstClassSeats;
    private int economyClassSeats;

}
