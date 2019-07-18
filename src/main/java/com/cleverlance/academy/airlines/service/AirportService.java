package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.client.AirportClient;
import com.cleverlance.academy.airlines.model.Destination;
import com.cleverlance.academy.airlines.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AirportService implements IAirportService {


    @Autowired
    AirportClient airportClient;

    @Autowired
    DestinationRepository destinationRepository;

    @Override
    public List<Destination> getAllAirports() {
        return destinationRepository.findAll();
    }

    @Scheduled(fixedRate = 3600000)
    private void updateAirports() {
        final List<Destination> apiAirports = airportClient.getAllAirports();
        final List<Destination> cachedAirports = destinationRepository.findAll();

        final Map<String, Destination> cachedAirportsMap = cachedAirports.stream()
                .collect(Collectors.toMap(Destination::getCode, item -> item));

        final Map<String, Destination> apiAirportsMap = apiAirports.stream()
                .collect(Collectors.toMap(Destination::getCode, item -> item));

        addAirporst(cachedAirportsMap, apiAirportsMap);
        deleteAirports(cachedAirportsMap, apiAirportsMap);

    }

    private void addAirporst(final Map<String, Destination> ca,
                             final Map<String, Destination> apia) {

        final Set<String> result = new HashSet(apia.keySet());
        result.removeAll(ca.keySet());

        apia.keySet().removeAll(ca.keySet());
        destinationRepository.saveAll(apia.values());

    }

    private void deleteAirports(final Map<String, Destination> cachedAirportsMap,
                                final Map<String, Destination> apiAirportsMap) {
        cachedAirportsMap.keySet().removeAll(apiAirportsMap.keySet());
        destinationRepository.deleteAll(cachedAirportsMap.values());
    }


}
