package com.cleverlance.academy.airlines.servicies;

import com.cleverlance.academy.airlines.repository.AirPlaneRepository;
import com.cleverlance.academy.airlines.entities.Airplane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneService implements IPlaneService{

    @Autowired
    AirPlaneRepository aR;

    @Override
    public List<Airplane> getAllAirplanes(){
        return aR.findAll();
    }

    @Override
    public void deletePlane(long id){
        aR.deleteById(id);

    }

    @Override
    public void updatePlane(Airplane aP){
        aR.saveAndFlush(aP);
    }

    @Override
    public void createPlane(Airplane aP){
        aR.saveAndFlush(aP);

    }

    @Override
    public Optional<Airplane> getPlaneById(final Long id) {
        return aR.findById(id);
    }

    @Override
    public Optional<Airplane> getPlaneByCode(final String code) {
        return Optional.ofNullable(aR.getPlaneByCode(code));
    }
}
