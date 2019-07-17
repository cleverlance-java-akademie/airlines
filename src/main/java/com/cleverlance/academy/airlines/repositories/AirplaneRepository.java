package com.cleverlance.academy.airlines.repositories;

import com.cleverlance.academy.airlines.entities.Airplane;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AirplaneRepository {

    private final Map<Long,Airplane> airplanes = new HashMap<>();

    public List<Airplane> getAirplanes() {
        return new ArrayList<>(this.airplanes.values());
    }

    public void createAirplane(Airplane airplane){
        this.airplanes.put(airplane.getId(),airplane);

    }

    public void deleteAirplane(final long id){
        this.airplanes.remove(id);

    }

    public void updateAirplane(Airplane airplane){
        this.airplanes.remove(airplane.getId());
        this.createAirplane(airplane);


    }
}
