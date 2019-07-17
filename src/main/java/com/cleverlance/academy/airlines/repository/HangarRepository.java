package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.model.Hangar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface HangarRepository extends JpaRepository<Hangar, Long>
{
}
