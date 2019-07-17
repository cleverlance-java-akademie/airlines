package com.cleverlance.academy.airlines.Repository;

import com.cleverlance.academy.airlines.entities.Airplane;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AirPlaneRepository {

    private Map<Long, Airplane> planes;

    public AirPlaneRepository() {
        this.planes = new HashMap<>();
    }

    public void createPlane(final Airplane aP){
        this.planes.put(aP.getId(), aP);

    }

    public void deletePlane(final long id){
        this.planes.remove(id);

    }

    public List<Airplane> getAllPlanes(){
        return new ArrayList<>(this.planes.values());
    }
}
