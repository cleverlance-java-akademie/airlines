package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Plane;
import com.cleverlance.academy.airlines.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService implements IPlaneService
{
    @Autowired
    private PlaneRepository planeRepository;

    @Override
    public List<Plane> getAllPlanes()
    {
        return planeRepository.findAll();
    }

    @Override
    public void deletePlane(long id)
    {
        planeRepository.deleteById(id);
    }

    @Override
    public void updatePlane(Plane plane)
    {
        planeRepository.saveAndFlush(plane);
    }

    @Override
    public void createPlane(Plane plane)
    {
        planeRepository.saveAndFlush(plane);
    }
}
