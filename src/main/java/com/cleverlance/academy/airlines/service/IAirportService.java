package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entities.Destination;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IAirportService {

    List<Destination> getAllAirports();
}
