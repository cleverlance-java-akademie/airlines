package com.cleverlance.academy.airlines.repositories;

import com.cleverlance.academy.airlines.entities.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Component
//@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

//    private final Map<Long,Airplane> airplanes = new HashMap<>();
//
//    public List<Airplane> getAirplanes() {
//        return new ArrayList<>(this.airplanes.values());
//    }
//
//    public void createAirplane(Airplane airplane){
//        this.airplanes.put(airplane.getId(),airplane);
//
//    }
//
//    public void deleteAirplane(final long id){
//        this.airplanes.remove(id);
//
//    }
//
//    public void updateAirplane(Airplane airplane){
//        this.airplanes.remove(airplane.getId());
//        this.createAirplane(airplane);
//
//
//    }
}
