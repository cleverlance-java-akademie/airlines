package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.entity.Destination;
import com.cleverlance.academy.airlines.entity.client.AirportClient;
import com.cleverlance.academy.airlines.repository.DestinationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AirportsService implements IAirportsService {

    @Autowired
    private AirportClient airportClient;

    @Autowired
    private DestinationRepo destinationRepository;

    @Override
    public List<Destination> getAllAirports() {
        return destinationRepository.findAll();
    }

    @Scheduled(fixedRate = 3600000)
    private void updateAirports() {
        final List<Destination> apiAirports = airportClient.getAllAirports();
        final List<Destination> cachedAirports = destinationRepository.findAll();

        final Map<String, Destination> cachedAirportsMap = cachedAirports
                .stream().collect(Collectors.toMap(Destination::getCode, item -> item));

        final Map<String, Destination> apiAirportsMap = apiAirports
                .stream().collect(Collectors.toMap(Destination::getCode, item -> item));
        addAirports(new HashMap<>(cachedAirportsMap), new HashMap<>(apiAirportsMap));
        deleteAirports(new HashMap<>(cachedAirportsMap), new HashMap<>(apiAirportsMap));
    }

    private void addAirports(final Map<String, Destination> cachedAirportsMap,
                             final Map<String, Destination> apiAirportsMap) {
        apiAirportsMap.keySet().removeAll(cachedAirportsMap.keySet());
        destinationRepository.saveAll(apiAirportsMap.values());
    }

    private void deleteAirports(final Map<String, Destination> cachedAirportsMap,
                                final Map<String, Destination> apiAirportsMap) {
        cachedAirportsMap.keySet().removeAll(apiAirportsMap.keySet());
        destinationRepository.deleteAll(cachedAirportsMap.values());
    }
}
