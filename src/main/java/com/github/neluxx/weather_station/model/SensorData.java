package com.github.neluxx.weather_station.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double temperature;

    @Positive
    private Double humidity;

    @Positive
    private Double pressure;

    @Positive
    private Double co2;

    @CreationTimestamp
    private Date created_at;

    @UpdateTimestamp
    private Date modified_at;

    public SensorData() {}

    public SensorData(Double temperature, Double humidity, Double pressure, Double co2) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.co2 = co2;
    }

    public Long getId() {
        return id;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getCo2() {
        return co2;
    }

    public void setCo2(Double co2) {
        this.co2 = co2;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getModified_at() {
        return modified_at;
    }
}
