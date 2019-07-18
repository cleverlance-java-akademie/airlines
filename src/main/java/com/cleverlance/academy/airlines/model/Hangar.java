package com.cleverlance.academy.airlines.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

// lombok
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
// JPA
@Entity
public class Hangar {

    @Id
    @GeneratedValue
    private Long hangarId;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Plane> planes;

}
