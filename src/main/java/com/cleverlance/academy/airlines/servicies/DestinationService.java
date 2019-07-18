package com.cleverlance.academy.airlines.servicies;

import com.cleverlance.academy.airlines.client.AirportClient;
import com.cleverlance.academy.airlines.entities.Destination;
import com.cleverlance.academy.airlines.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@EnableScheduling
@Service
public class DestinationService implements IDestinationService {

    @Autowired
    DestinationRepository dR;

    @Autowired
    AirportClient aC;

    //@Override
    public void createAllAirports() {
        dR.saveAll(aC.getAllAirports());
    }

    @Override
    public List<Destination> getAllDestinations() {
        return dR.findAll();
    }

    @Override
    @Scheduled(fixedRate = 86400000)
    public void updateDestinations() {

        List<Destination> apiDestinations = aC.getAllAirports();
        if(!getAllDestinations().equals(apiDestinations)){


        }

    }
}
