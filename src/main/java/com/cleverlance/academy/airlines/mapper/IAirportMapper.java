package com.cleverlance.academy.airlines.mapper;

import com.cleverlance.academy.airlines.entity.Destination;
import generated.restclient.model.AirportGen;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAirportMapper {

    Destination convertToDestination(AirportGen airport);
}
