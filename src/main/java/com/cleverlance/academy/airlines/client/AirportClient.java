package com.cleverlance.academy.airlines.client;

import com.cleverlance.academy.airlines.model.Destination;
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
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportClient implements IAirportClient {

    private AirportApi airportApi;

    @Inject
    private ApiClient apiClient;

    @Value("api.key")
    private String apiKey;

    @PostConstruct
    protected void initApi() {
        airportApi = new AirportApi(apiClient);
    }


    @Override
    public List<Destination> getAllAirports() {
        try {
            final ResponseGen res = airportApi.getAllAirports(apiKey);
            return convertToDestinations(res.getResponse());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private List<Destination> convertToDestinations(final AirportListGen alg) {
        return alg.stream()
                .map(item -> convertToDestination(item)).collect(Collectors.toList());
    }

    private Destination convertToDestination(final AirportGen ag) {
        return Destination.builder().code(ag.getCode()).name(ag.getName()).build();
    }
}
