package com.cleverlance.academy.airlines.client;

import generated.restclient.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.client.ClientBuilder;

@Configuration
public class ClientConfig {

    @Bean
    @Value("${airlines.airports.url}")
    public ApiClient apiClient(final String url) {
        final ApiClient apiClient = new ApiClient();

        apiClient.setBasePath(url);
        apiClient.setHttpClient(ClientBuilder.newBuilder().build());

        return apiClient;
    }
}
