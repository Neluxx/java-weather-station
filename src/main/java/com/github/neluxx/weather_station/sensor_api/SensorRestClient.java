package com.github.neluxx.weather_station.sensor_api;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class SensorRestClient {

    private final RestClient restClient;

    public SensorRestClient(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://jsonplaceholder.typicode.com/").build();
    }

    public List<Sensor> findAll() {
    return restClient.get().uri("/users").retrieve().body(new ParameterizedTypeReference<>() {});
    }

    public Sensor findById(Integer id) {
        return restClient.get().uri("/users/{id}", id).retrieve().body(Sensor.class);
    }
}
