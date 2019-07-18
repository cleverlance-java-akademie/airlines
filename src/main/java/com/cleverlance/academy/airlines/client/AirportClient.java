package com.cleverlance.academy.airlines.client;

import com.cleverlance.academy.airlines.mapper.AirportMapper;
import com.cleverlance.academy.airlines.model.Destination;
import generated.restclient.ApiClient;
import generated.restclient.ApiException;
import generated.restclient.api.AirportApi;
import generated.restclient.model.AirportListGen;
import generated.restclient.model.ResponseGen;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AirportClient implements IAirportClient {

    @Value("${airlines.airports.apikey}")
    private String apiKey;

    private AirportApi airportApi;

    @Autowired
    private ApiClient apiClient;

    @Autowired
    private AirportMapper airportMapper;

    @PostConstruct
    protected void initApi() {
        airportApi = new AirportApi(apiClient);
    }

    @Override
    public List<Destination> getALlAirports() {
        try {
            final ResponseGen result = airportApi.getAllAirports(apiKey);
            return convertToDestinations(result.getResponse());
        } catch (ApiException e) {
//            e.printStackTrace();
            log.error("Failed to call getAllAirports API ", e);
        }
        return Collections.emptyList();
    }

    private List<Destination> convertToDestinations(final AirportListGen airportListGen) {
        return airportListGen.stream()
                .map(item -> airportMapper.convertToDestination(item))
                .collect(Collectors.toList());
    }

}
