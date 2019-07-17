package com.cleverlance.academy.airlines.entities;

public class Airplane {
    private final String registrationSign;
    private int seatsEconomy;
    private int seatsPremium;
    private final long id;

    public Airplane(String registrationSign, int seatsEconomy, int seatsPremium, int id) {
        this.registrationSign = registrationSign;
        this.seatsEconomy = seatsEconomy;
        this.seatsPremium = seatsPremium;
        this.id = id;
    }

    public int getSeatsEconomy() {
        return seatsEconomy;
    }

    public void setSeatsEconomy(int seatsEconomy) {
        this.seatsEconomy = seatsEconomy;
    }

    public int getSeatsPremium() {
        return seatsPremium;
    }

    public void setSeatsPremium(int seatsPremium) {
        this.seatsPremium = seatsPremium;
    }

    public String getRegistrationSign() {
        return registrationSign;
    }

    public long getId() {
        return id;
    }
}
