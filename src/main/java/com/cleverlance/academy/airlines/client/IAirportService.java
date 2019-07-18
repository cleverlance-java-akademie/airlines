package com.cleverlance.academy.airlines.client;

import com.cleverlance.academy.airlines.model.Destination;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IAirportService {

    List<Destination> getAllAirports();

}
