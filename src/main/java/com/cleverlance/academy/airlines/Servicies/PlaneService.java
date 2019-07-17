package com.cleverlance.academy.airlines.Servicies;

import com.cleverlance.academy.airlines.Repository.AirPlaneRepository;
import com.cleverlance.academy.airlines.entities.Airplane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService implements IPlaneService{

    @Autowired
    AirPlaneRepository aR;

    public List<Airplane> getAllAirplanes(){
        return aR.getAllPlanes();
    }

    public void deletePlane(long id){
        aR.deletePlane(id);

    }

    public void updatePlane(long id, Airplane aP){
        aR.deletePlane(id);
        aR.createPlane(aP);
    }

    public void createPlane(Airplane aP){
        aR.createPlane(aP);

    }
}
