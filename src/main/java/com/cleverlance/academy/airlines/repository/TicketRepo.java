package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Long> {
}
