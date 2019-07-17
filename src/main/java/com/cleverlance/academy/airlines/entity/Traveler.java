package com.cleverlance.academy.airlines.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Traveler {

    @Id
    @GeneratedValue
    private Long travelerId;
    private String firstName;
    private String lastName;
    private DocumentType documentType;


}
