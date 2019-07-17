package com.cleverlance.academy.airlines.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*LomBok*/
@Data /*creates setters & getters*/
@AllArgsConstructor /*all arguments constructor*/
@NoArgsConstructor
@Builder
/*JPA*/
@Entity
public class Plane
{
    @Id
    @GeneratedValue
    private long id;
    private String registrationNumber;
    private int numberInFirstClass;
    private int numberInEconomyClass;
}
