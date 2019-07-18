package com.cleverlance.academy.airlines.mapper;


import com.cleverlance.academy.airlines.entities.Airplane;
import generated.rest.model.AirplaneGen;
import generated.restclient.model.AirportGen;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirplaneMapper {

    AirplaneGen convertToAirplaneGen(Airplane airplane);
}
