package com.cleverlance.academy.airlines.mapper;

import com.cleverlance.academy.airlines.model.Hangar;
import generated.rest.model.HangarGen;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HangarMapper
{
    HangarGen convertToHangarGen(Hangar hangar);

}
