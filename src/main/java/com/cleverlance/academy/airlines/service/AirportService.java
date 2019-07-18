package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.client.IAirportClient;
import com.cleverlance.academy.airlines.model.Destination;
import com.cleverlance.academy.airlines.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AirportService implements IAirportService {

    @Autowired
    private IAirportClient airportClient;

    @Autowired
    private DestinationRepository destinationRepo;

    @Override
    public List<Destination> getAllAirports() {
        return airportClient.getAllAirports();
    }

    @Scheduled(fixedRate = 3600000)
    private void updateAirports() {
        final List<Destination> apiAirports = getAllAirports();
        final List<Destination> cachedAirports = destinationRepo.findAll();

        final Map<String, Destination> cachedAirportsMap = cachedAirports
                .stream().collect(Collectors.toMap(Destination::getCode, item -> item));

        final Map<String, Destination> apiAirportsMap = apiAirports
                .stream().collect(Collectors.toMap(Destination::getCode, item -> item));
        addAirports(new HashMap<>(cachedAirportsMap), apiAirportsMap);
        deleteAirports(new HashMap<>(cachedAirportsMap), apiAirportsMap);
    }

    private void addAirports(final Map<String, Destination> cachedAirportsMap,
                             final Map<String, Destination> apiAirportsMap) {
        apiAirportsMap.keySet().removeAll(cachedAirportsMap.keySet());
        destinationRepo.saveAll(apiAirportsMap.values());
    }

    private void deleteAirports(final Map<String, Destination> cachedAirportsMap,
                                final Map<String, Destination> apiAirportsMap) {
        cachedAirportsMap.keySet().removeAll(apiAirportsMap.keySet());
        destinationRepo.deleteAll(cachedAirportsMap.values());
    }
}