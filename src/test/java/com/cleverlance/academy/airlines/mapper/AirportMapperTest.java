package com.cleverlance.academy.airlines.mapper;

import com.cleverlance.academy.airlines.entities.Destination;
import generated.restclient.model.AirportGen;
import org.junit.Test;

public class AirportMapperTest {

    private AirportMapper mapper = new AirportMapperImpl();

    @Test
    public void convertToDestination(){

        final AirportGen data = new AirportGen().code("ABC").name("neco");
        final Destination converted = mapper.convertToDestination(data);

        //assertEquals();


    }
}
