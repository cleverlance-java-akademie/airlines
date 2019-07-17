package com.cleverlance.academy.airlines.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Airplane {

    private long id;
    private String code;
    private int numOfSeatsInFC;
    private int numOfSeatsInEC;
}
