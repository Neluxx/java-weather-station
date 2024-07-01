package com.github.neluxx.weather_station.controller;

import com.github.neluxx.weather_station.exception.SensorDataNotFoundException;
import com.github.neluxx.weather_station.model.Sensor;
import com.github.neluxx.weather_station.repository.SensorRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sensor-data")
public class SensorController {

    private final SensorRepository sensorRepository;

    public SensorController(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @GetMapping("")
    List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    @GetMapping("/{id}")
    Sensor findById(@PathVariable Integer id) {
        Optional<Sensor> sensorData = sensorRepository.findById(id);

        if (sensorData.isEmpty()) {
            throw new SensorDataNotFoundException();
        }

        return sensorData.get();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    void create(@Valid @RequestBody Sensor sensor) {
        sensorRepository.create(sensor);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@Valid @RequestBody Sensor sensor, @PathVariable Integer id) {
        sensorRepository.update(sensor, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Integer id) {
        sensorRepository.delete(id);
    }
}
