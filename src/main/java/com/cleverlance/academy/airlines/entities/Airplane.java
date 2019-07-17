package com.cleverlance.academy.airlines.entities;

public class Airplane {
    private long id;
    private String code;
    private int numOfSeatsInFC;
    private int numOfSeatsInEC;

    public Airplane(int id, String code, int numOfSeatsInFC, int numOfSeatsInEC) {
        this.id = id;
        this.code = code;
        this.numOfSeatsInFC = numOfSeatsInFC;
        this.numOfSeatsInEC = numOfSeatsInEC;
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public int getNumOfSeatsInFC() {
        return numOfSeatsInFC;
    }

    public int getNumOfSeatsInEC() {
        return numOfSeatsInEC;
    }
}
