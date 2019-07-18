package com.cleverlance.academy.airlines.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Passenger {

    @Id
    @GeneratedValue
    private Long passengerId;

    private String firstName;
    private String lastName;
    private String documentId;
    private DocumentType documentType;
}
