package com.temperatures.temperatures.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"temperature"})
public class TemperatureFahrenheit extends Temperature {
    private Float TemperatureInFahrenheit;

    public TemperatureFahrenheit() { }

    public TemperatureFahrenheit(Temperature temperature) {
        this.setId(temperature.getId());
        this.setTemperatureInFahrenheit((temperature.getTemperature()  * 9 / 5) + 32);
        this.setCreateDate(temperature.getCreateDate());
        this.setUpdateDate(temperature.getUpdateDate());
    }

    public Float getTemperatureInFahrenheit() {
        return TemperatureInFahrenheit;
    }

    public void setTemperatureInFahrenheit(Float value) {
        TemperatureInFahrenheit = value;
    }
}
