package com.cleverlance.academy.airlines.client;

import com.cleverlance.academy.airlines.entity.Destination;
import com.cleverlance.academy.airlines.mapper.IAirportMapper;
import generated.restclient.ApiClient;
import generated.restclient.ApiException;
import generated.restclient.api.AirportApi;
import generated.restclient.model.AirportGen;
import generated.restclient.model.AirportListGen;
import generated.restclient.model.ResponseGen;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Log4j2
@Service
public class AirportClient implements IAirportClient {


   private AirportApi airportApi;

    @Autowired
    private ApiClient apiClient;

    @Autowired
    private IAirportMapper airportMapper;

    @Value("${airlines.airports.key}")
    private String apiKey;

    @PostConstruct
    protected void initApi() {
        airportApi = new AirportApi(apiClient);
    }

    @Override
    public List<Destination> getAllAirports() {
        try {
            final ResponseGen result = airportApi.getAllAirports(apiKey);
            return convertToDestinations(result.getResponse());
        } catch (final ApiException e) {
            log.error("Failed to call airport", e);
        }
        return Collections.emptyList();
    }

    private List<Destination> convertToDestinations(final AirportListGen list){
        return list.stream()
                .map(item -> convertToDestination(item))
                .collect(Collectors.toList());

    }

    private Destination convertToDestination(final AirportGen airport){
        return Destination.builder()
                .code(airport.getCode())
                .name(airport.getName())
                .build();
    }
}
