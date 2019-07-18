package com.cleverlance.academy.airlines.entities;

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
@Builder
public class Traveler {

    @Id
    @GeneratedValue
    private Long travelerId;

    private  String firstName;
    private String lastName;
    private int numOfDocument;
    private DocumentType documentType;

}
