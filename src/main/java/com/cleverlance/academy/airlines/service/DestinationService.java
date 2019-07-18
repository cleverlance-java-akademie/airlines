package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.client.IAirportClient;
import com.cleverlance.academy.airlines.model.Destination;
import com.cleverlance.academy.airlines.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DestinationService implements IDestinationService {

    @Autowired
    private IAirportClient airportClient;

    @Autowired
    private DestinationRepository destinationRepository;

    @Override
    public List<Destination> getAll() {
        return destinationRepository.findAll();
    }

    @Override
    public void delete(final Long aLong) {
        destinationRepository.deleteById(aLong);
    }

    @Override
    public void update(final Destination e) {
        destinationRepository.save(e);
    }

    @Override
    public void create(final Destination e) {
        destinationRepository.save(e);
    }

    @Override
    public Optional<Destination> getById(final Long id) {
        return destinationRepository.findById(id);
    }

    @Scheduled(fixedRate = 36000000)
    private void loadFromThirdParty() {
        Map<String, Destination> persistedDestinations = destinationRepository.findAll().stream()
                .collect(Collectors.toMap(Destination::getCode, d -> d));
        Map<String, Destination> freshDestinations = airportClient.getAllAirports().stream()
                .collect(Collectors.toMap(Destination::getCode, d -> d));

        removeOld(new HashMap<>(persistedDestinations), freshDestinations);
        addNew(new HashMap<>(freshDestinations), persistedDestinations);
    }

    private void removeOld(Map<String, Destination> persisted, Map<String, Destination> fresh) {
        persisted.keySet().removeAll(fresh.keySet()); // 'persisted' now contains deleted airports from API
        destinationRepository.deleteAll(persisted.values());
    }

    private void addNew(Map<String, Destination> persisted, Map<String, Destination> fresh) {
        fresh.keySet().removeAll(persisted.keySet()); // 'fresh' now contains new airports from API
        destinationRepository.saveAll(fresh.values());
    }
}
