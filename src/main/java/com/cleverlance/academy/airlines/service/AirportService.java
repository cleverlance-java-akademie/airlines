package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.client.IAirportClient;
import com.cleverlance.academy.airlines.model.Destination;
import com.cleverlance.academy.airlines.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AirportService implements IAirportService {
    @Autowired
    AirportRepository airportRepository;

    @Autowired
    IAirportClient airportClient;

    @Override
    public List<Destination> getAllAirports() {
        return airportRepository.findAll();
    }

    @Override
    public Destination getARandomAirport() {
        List<Destination> flights = getAllAirports();
        Random random = new Random();
        return flights.get(random.nextInt() % flights.size());
    }

    @Scheduled(fixedRate = 3600000)
    private void updateAirports() {
        final List<Destination> apiAirports = airportClient.getAllAirports();
        final List<Destination> cachedAirports = airportRepository.findAll();

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
        airportRepository.saveAll(apiAirportsMap.values());
    }

    private void deleteAirports(final Map<String, Destination> cachedAirportsMap,
                                final Map<String, Destination> apiAirportsMap) {
        cachedAirportsMap.keySet().removeAll(apiAirportsMap.keySet());
        airportRepository.deleteAll(cachedAirportsMap.values());
    }
}
