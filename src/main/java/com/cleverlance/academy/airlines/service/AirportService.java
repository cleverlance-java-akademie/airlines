package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.client.AirportClient;
import com.cleverlance.academy.airlines.model.Destination;
import com.cleverlance.academy.airlines.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AirportService implements IAirportService
{

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private AirportClient airportClient;

    @Override
    public List<Destination> getAllAirports()
    {
        return destinationRepository.findAll();
    }

    @Override
    public Destination getRandomAirport()
    {
        final List<Destination> flights = getAllAirports();
        final Random rand = new Random();
        return flights.get(rand.nextInt(flights.size()));
    }

    @Scheduled(fixedRate = 3600000)
    private void updateAirports()
    {
        final List<Destination> apiAirports = airportClient.getAllAirports();
        final List<Destination> cachedAirports = destinationRepository.findAll();

        final Map<String, Destination> cachedAirportsCodes = cachedAirports.stream()
                .collect(Collectors.toMap(Destination::getCode, item -> item));

        final Map<String, Destination> apiAirportsCodes = apiAirports.stream()
                .collect(Collectors.toMap(Destination::getCode, item -> item));

        addAirports(new HashMap<>(cachedAirportsCodes), new HashMap<>(apiAirportsCodes));
        deleteAirports(new HashMap<>(cachedAirportsCodes), new HashMap<>(apiAirportsCodes));
    }

    private void addAirports(final Map<String, Destination> cachedAirportsMap, final Map<String, Destination> apiAirportsMap)
    {
        apiAirportsMap.keySet().removeAll(cachedAirportsMap.keySet()); /*množina dosud nepřidaných letišť*/
        destinationRepository.saveAll(apiAirportsMap.values());

    }

    private void deleteAirports(final Map<String, Destination> cachedAirportsMap, final Map<String, Destination> apiAirportsMap)
    {
        cachedAirportsMap.keySet().removeAll(apiAirportsMap.keySet());
        destinationRepository.deleteAll(cachedAirportsMap.values());

    }


}
