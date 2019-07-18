package com.cleverlance.academy.airlines.servicies;

import com.cleverlance.academy.airlines.client.AirportClient;
import com.cleverlance.academy.airlines.entities.Destination;
import com.cleverlance.academy.airlines.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

        final List<Destination> apiDestinations = aC.getAllAirports();
        final List<Destination> dbDestinations = dR.findAll();

        final Map<String, Destination> dbAirportsCodes = dbDestinations.stream().collect(Collectors.toMap(Destination::getCode,item -> item));
        final Map<String, Destination> dbAirportsCodes2 = dbDestinations.stream().collect(Collectors.toMap(Destination::getCode,item -> item));
        final Map<String, Destination> apiAirportsCodes = apiDestinations.stream().collect(Collectors.toMap(Destination::getCode,item -> item));
        final Map<String, Destination> apiAirportsCodes2 = apiDestinations.stream().collect(Collectors.toMap(Destination::getCode,item -> item));

        if(!dbAirportsCodes.equals(apiAirportsCodes)){

            apiAirportsCodes.keySet().removeAll(dbAirportsCodes.keySet());
            dR.saveAll(apiAirportsCodes.values());

            dbAirportsCodes2.keySet().removeAll(apiAirportsCodes2.keySet());
            dR.deleteAll(dbAirportsCodes2.values());
        }

    }
}
