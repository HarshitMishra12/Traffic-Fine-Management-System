package com.harshit.traffic_system.controller;

import com.harshit.traffic_system.model.Vehicle;
import com.harshit.traffic_system.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleRepository repository;

    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return repository.save(vehicle);
    }

    @GetMapping
    public List<Vehicle> getVehicles() {
        return repository.findAll();
    }
}
