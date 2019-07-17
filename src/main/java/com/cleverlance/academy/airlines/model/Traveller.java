package com.cleverlance.academy.airlines.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Traveller {
    @Id
    @GeneratedValue
    private Long travellerId;
    private String firstName;
    private String lastName;
    private TravellerDocumentType travellerDocumentType;
}
