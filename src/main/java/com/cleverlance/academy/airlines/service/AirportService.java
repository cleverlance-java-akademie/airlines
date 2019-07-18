package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.client.IAirportClient;
import com.cleverlance.academy.airlines.model.Destination;
import com.cleverlance.academy.airlines.repository.AirportDestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AirportService {

    @Autowired
    private IAirportClient iAirportclient;
    @Autowired
    private AirportDestinationRepository airportDestinationRepository;


    @Scheduled(fixedRate = 36000000)
    private void updateAirports() {
        final List<Destination> apiAirports = iAirportclient.getAllAirports();
        final List<Destination> cachedAirports = airportDestinationRepository.findAll();

        final Map<String, Destination> cachedAirportsMap = cachedAirports.stream().collect(Collectors.toMap(Destination::getCode, item -> item));
        final Map<String, Destination> apiAirportsMap = cachedAirports.stream().collect(Collectors.toMap(Destination::getCode, item -> item));
        addAirports(cachedAirportsMap, apiAirportsMap);
    }

    private void addAirports(final Map<String, Destination> cachedAirportsMap, final Map<String, Destination> apiAirportsMap) {
        apiAirportsMap.keySet().removeAll(cachedAirportsMap.keySet());
        airportDestinationRepository.saveAll(apiAirportsMap.values());
    }

    private void deleteAirports(final Map<String, Destination> cachedAirportsMap, final Map<String, Destination> apiAirportsMap) {
        cachedAirportsMap.keySet().removeAll(apiAirportsMap.keySet());
        airportDestinationRepository.saveAll(apiAirportsMap.values());
    }

}
