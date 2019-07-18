package com.cleverlance.academy.airlines.client;

import com.cleverlance.academy.airlines.entities.Destination;
import generated.restclient.ApiClient;
import generated.restclient.ApiException;
import generated.restclient.api.AirportApi;
import generated.restclient.model.AirportGen;
import generated.restclient.model.AirportListGen;
import generated.restclient.model.ResponseGen;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportClient implements IAirportClient{

    private AirportApi airportApi;

    @Inject
    private ApiClient apiClient;

    @Value("airlines.airports.key")
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
        } catch (ApiException e) {
            e.printStackTrace();
        }


        return null;
    }


    private List<Destination> convertToDestinations(final AirportListGen list){
        return list.stream()
                .map(this::convertToDestination)
                .collect(Collectors.toList());
    }


    private Destination convertToDestination(final AirportGen airport){
        return Destination.builder()
                .code(airport.getCode())
                .name(airport.getName()).build();
    }
}
