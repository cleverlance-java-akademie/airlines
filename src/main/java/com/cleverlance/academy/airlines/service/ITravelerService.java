package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entity.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITravelerService {

    void createTraveler (Traveler traveler);
}
