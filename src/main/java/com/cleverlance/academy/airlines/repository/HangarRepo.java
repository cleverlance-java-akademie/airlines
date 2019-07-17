package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.entities.Hangar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface HangarRepo extends JpaRepository<Hangar, Long> {
}
