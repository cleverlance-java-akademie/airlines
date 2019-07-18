package com.cleverlance.academy.airlines.mapper;

import com.cleverlance.academy.airlines.entities.Destination;
import generated.restclient.model.AirportGen;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAirportMapper {

    Destination convertToDestination(AirportGen airportGen);
}
