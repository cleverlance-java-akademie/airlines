package com.cleverlance.academy.airlines.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data // implements getters and setters for all members
@Builder
@AllArgsConstructor // defines all members to be build in constructor
@NoArgsConstructor
@Entity
public class Hangar {
    @Id
    @GeneratedValue
    private Long hangarId;
    private String name;
    @OneToMany
    private List<Plane> planes;
}
