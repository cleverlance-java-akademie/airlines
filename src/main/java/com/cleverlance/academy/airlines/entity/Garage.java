package com.cleverlance.academy.airlines.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Garage {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany
    private List<Aircraft> aircrafts;
}
