package com.cleverlance.academy.airlines.entity.client;

import com.cleverlance.academy.airlines.entity.Destination;

import java.util.List;

public interface IAirportClient {

    List<Destination> getAllAirports();
}
