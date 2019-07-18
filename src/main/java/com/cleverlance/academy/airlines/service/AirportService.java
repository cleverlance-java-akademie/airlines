package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.client.AirportClient;
import com.cleverlance.academy.airlines.entities.Destination;
import com.cleverlance.academy.airlines.repositories.AirplaneRepository;
import com.cleverlance.academy.airlines.repositories.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AirportService implements IAirportService {
    @Autowired
    private AirportClient airportClient;

    @Autowired
    private DestinationRepository airportRepository;

    @Override
    public List<Destination> getAllAirports() {
        return airportRepository.findAll();
    }

    @Scheduled(fixedRate = 3600000)
    private void updateAirports() {
        final List<Destination> apiAirports = airportClient.getAllAirports();
        final List<Destination> dbsAirports = airportRepository.findAll();

        final Map<String,Destination> apiAirportCodes = apiAirports.stream()
                .collect(Collectors.toMap(Destination::getCode,item->item));

        final Map<String,Destination> dbsAirportCodes = dbsAirports.stream()
                .collect(Collectors.toMap(Destination::getCode,item->item));
        addAirports(new HashMap<>(dbsAirportCodes),new HashMap<>(apiAirportCodes));
        deleteAirports(new HashMap<>(dbsAirportCodes),new HashMap<>(apiAirportCodes));
    }

    private void addAirports(Map<String,Destination> cachedAirportCodes,Map<String,Destination> apiAirportCodes){
        apiAirportCodes.keySet().removeAll(cachedAirportCodes.keySet());
        airportRepository.saveAll(apiAirportCodes.values());
    }

    private void deleteAirports(Map<String,Destination> cachedAirportCodes,Map<String,Destination> apiAirportCodes){
        cachedAirportCodes.keySet().removeAll(apiAirportCodes.keySet());
        airportRepository.deleteAll(apiAirportCodes.values());
    }
}
