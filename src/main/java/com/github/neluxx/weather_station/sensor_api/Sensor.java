package com.github.neluxx.weather_station.sensor_api;

import jakarta.validation.constraints.Positive;

public record Sensor(
        Integer id,
        Double temperature,
        @Positive
        Double humidity,
        @Positive
        Double pressure,
        @Positive
        Double co2
) {

    public Sensor {
        if (temperature < -100.0 || temperature > 100.0) {
            throw new IllegalArgumentException("Unrealistic temperature");
        }

        if (humidity < 0.0 || humidity > 100.0) {
            throw new IllegalArgumentException("Humidity must be between 0 and 100");
        }

        if (pressure < 0.0) {
            throw new IllegalArgumentException("Pressure cannot be negative");
        }

        if (co2 < 0.0) {
            throw new IllegalArgumentException("CO2 concentration cannot be negative");
        }
    }
}
