package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TicketsRepo extends JpaRepository<Ticket, Long> {


}
