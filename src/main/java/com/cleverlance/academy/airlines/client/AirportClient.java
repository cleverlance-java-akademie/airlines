package com.cleverlance.academy.airlines.client;

import com.cleverlance.academy.airlines.entities.Destination;
import com.cleverlance.academy.airlines.mapper.IAirportMapper;
import generated.restclient.ApiClient;
import generated.restclient.ApiException;
import generated.restclient.api.AirportApi;
import generated.restclient.model.AirportGen;
import generated.restclient.model.AirportListGen;
import generated.restclient.model.ResponseGen;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AirportClient implements IAirportClient {

    private AirportApi airportApi;

    @Autowired
    private IAirportMapper airportMapper;

    @Value("${airlines.airports.apikey}")
    private String apiKey;

    @Autowired
    private ApiClient apiClient;

    @PostConstruct
    protected void initApi(){
        airportApi = new AirportApi(apiClient);
    }

    @Override
    public List<Destination> getAllAirports() {
        try {
            final ResponseGen result = airportApi.getAllAirports(apiKey);
            return convertToDestination(result.getResponse());
        } catch (ApiException e) {
            log.error("Failed to call airport",e);
        }
        return Collections.emptyList();

    }

    private List<Destination> convertToDestination(final AirportListGen airportListGen){
        return airportListGen.stream()
                .map(item -> airportMapper.convertToDestination(item))
                .collect(Collectors.toList());
    }
}
