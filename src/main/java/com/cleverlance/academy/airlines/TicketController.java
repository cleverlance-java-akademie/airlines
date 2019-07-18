/*package com.cleverlance.academy.airlines;


import com.cleverlance.academy.airlines.model.Ticket;
import com.cleverlance.academy.airlines.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    ITicketService iTicketService;

    @RequestMapping(path="/tickets/{startDestination}/{finalDestination}/{numberOfSeats}",  method = RequestMethod.POST)
    public void createTickets(@PathVariable("startDestination") String startDestination, @PathVariable("finalDestination") String finalDestination, @PathVariable("numberOfSeats") long numberOfSeats){
        iTicketService.createTickets(startDestination, finalDestination, numberOfSeats);
    }

}
*/