package com.cleverlance.academy.airlines.repositories;

import com.cleverlance.academy.airlines.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
