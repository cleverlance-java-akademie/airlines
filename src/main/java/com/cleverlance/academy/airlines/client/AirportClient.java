package com.cleverlance.academy.airlines.client;

import com.cleverlance.academy.airlines.entities.Destination;
import com.cleverlance.academy.airlines.mapper.AirportMapper;
import generated.restclient.ApiClient;
import generated.restclient.ApiException;
import generated.restclient.api.AirportApi;
import generated.restclient.model.AirportListGen;
import generated.restclient.model.ResponseGen;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Builder
@Slf4j
public class AirportClient implements IAirportClient{


    private AirportApi airportApi;

    @Autowired
    private ApiClient apiClient;

    @Autowired
    private AirportMapper airportMapper;

    @Value("${airlines.airports.key}")
    private String apiKey;

    @PostConstruct
    protected void initApi() {
        airportApi = new AirportApi(apiClient);
    }

    @Override
    public List<Destination> getAirports() {
        try {
            final ResponseGen result = airportApi.getAllAirports(apiKey);
            convertToDestinations(result.getResponse());
        } catch (ApiException e) {
            log.error("Failed to call airport", e);
        }
        return Collections.emptyList();
    }

    private List<Destination> convertToDestinations(final AirportListGen list){
        return list.stream()
                .map(item -> airportMapper.convertToDestination(item))
                .collect(Collectors.toList());
    }

}