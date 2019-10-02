package com.temperatures.temperatures.repositories;

import com.temperatures.temperatures.models.Temperature;
import org.springframework.data.repository.CrudRepository;

public interface TemperatureRepository extends CrudRepository<Temperature, Integer> {

}