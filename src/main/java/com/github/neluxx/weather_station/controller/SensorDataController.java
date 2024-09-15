package com.github.neluxx.weather_station.controller;

import com.github.neluxx.weather_station.exception.SensorDataNotFoundException;
import com.github.neluxx.weather_station.model.SensorData;
import com.github.neluxx.weather_station.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensor-data")
public class SensorDataController {

    @Autowired
    private SensorDataService sensorDataService;

    @GetMapping
    public List<SensorData> getAllSensorData() {
        return sensorDataService.getAllSensorData();
    }

    @GetMapping("/{id}")
    public SensorData getSensorDataById(@PathVariable Long id) {
        return sensorDataService.getSensorDataById(id).orElseThrow(SensorDataNotFoundException::new);
    }

    @PostMapping
    public SensorData createSensorData(@RequestBody SensorData sensorData) {
        return sensorDataService.saveSensorData(sensorData);
    }

    @PutMapping("/{id}")
    public SensorData updateSensorData(@PathVariable Long id, @RequestBody SensorData sensorDataDetails) {
        return sensorDataService.updateSensorData(id, sensorDataDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteSensorData(@PathVariable Long id) {
        sensorDataService.deleteSensorData(id);
    }
}
