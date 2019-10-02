package com.temperatures.temperatures.controllers;

import com.temperatures.temperatures.models.Temperature;
import com.temperatures.temperatures.models.TemperatureFahrenheit;
import com.temperatures.temperatures.repositories.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TemperatureController {
    @Autowired
    private TemperatureRepository repo;

    TemperatureController() {
    }

    @GetMapping("/allTemperatures")
    List<Object> getAllTemperatures() {
        Iterable<Temperature> temperatures = repo.findAll();
        List<Object> returnTemperatures = new ArrayList<>();

        for (Temperature temperature: temperatures) {
            returnTemperatures.add(temperature);
            returnTemperatures.add(new TemperatureFahrenheit(temperature));
        }

        return returnTemperatures;
    }

    @GetMapping("/temperature/{id}")
    Temperature getTemperature(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("id does not exist"));
    }

    @PostMapping("/temperature")
    Temperature newTemperature(@RequestBody Temperature temperature) {
        return repo.save(temperature);
    }

    @PutMapping("/temperature/{id}")
    Temperature replaceTemperature(@RequestBody Temperature newTemperature, @PathVariable Integer id) {
        return repo.findById(id).map(temperature -> {
            temperature.setTemperature(newTemperature.getTemperature());
            return repo.save(temperature);
        }).orElseGet(() -> {
            newTemperature.setId(id);
            return repo.save(newTemperature);
        });
    }

    @DeleteMapping("/temperature/{id}")
    void deleteTemperature(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}
