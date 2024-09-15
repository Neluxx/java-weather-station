package com.github.neluxx.weather_station.service;

import com.github.neluxx.weather_station.model.SensorData;
import com.github.neluxx.weather_station.repository.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorDataService {

    @Autowired
    private SensorDataRepository sensorDataRepository;

    public List<SensorData> getAllSensorData() {
        return sensorDataRepository.findAll();
    }

    public Optional<SensorData> getSensorDataById(Long id) {
        return sensorDataRepository.findById(id);
    }

    public SensorData saveSensorData(SensorData sensorData) {
        return sensorDataRepository.save(sensorData);
    }

    public void deleteSensorData(Long id) {
        sensorDataRepository.deleteById(id);
    }

    public SensorData updateSensorData(Long id, SensorData sensorDataDetails) {
        SensorData sensorData = sensorDataRepository.findById(id).orElseThrow();
        sensorData.setTemperature(sensorDataDetails.getTemperature());
        sensorData.setHumidity(sensorDataDetails.getHumidity());
        sensorData.setPressure(sensorDataDetails.getPressure());
        sensorData.setCo2(sensorDataDetails.getCo2());

        return sensorDataRepository.save(sensorData);
    }
}
