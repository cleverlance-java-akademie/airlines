package com.cleverlance.academy.airlines.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Traveller {

    @Id
    @GeneratedValue
    private long travellerId;
    private String name;
    private String documentId;
    private DocumentType documentType;

}
