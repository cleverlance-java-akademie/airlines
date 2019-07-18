package com.cleverlance.academy.airlines.mapper;


import com.cleverlance.academy.airlines.model.Destination;
import generated.restclient.model.AirportGen;
import org.aspectj.lang.annotation.After;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AirportMapper{
    Destination convertToDestination(AirportGen airport);

}
