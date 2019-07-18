package com.cleverlance.academy.airlines.mapper;

import com.cleverlance.academy.airlines.entity.Destination;
import generated.restclient.model.AirportGen;
import org.junit.Assert;
import org.junit.Test;

public class AirportMapperTest {

    private IAirportMapper mapper = new IAirportMapperImpl();

    @Test
    public void convertToDestination(){
        final AirportGen date = new AirportGen().code("ABC").name("Abcde");
        final Destination converted = mapper.convertToDestination(date);

        Assert.assertEquals("ABC", converted.getCode());
        Assert.assertEquals("Abcde", converted.getName());
    }

}
