package com.harshit.traffic_system.controller;

import com.harshit.traffic_system.model.Challan;
import com.harshit.traffic_system.repository.ChallanRepository;
import com.harshit.traffic_system.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin
public class DashboardController {

    @Autowired
    private ChallanRepository challanRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("/stats")
    public Map<String,Object> getStats(){

        Map<String,Object> data = new HashMap<>();

        List<Challan> challans = challanRepository.findAll();

        int totalChallans = challans.size();
        int totalVehicles = vehicleRepository.findAll().size();

        int totalFine = challans.stream()
                .mapToInt(c -> c.getFineAmount())
                .sum();

        data.put("totalChallans", totalChallans);
        data.put("totalVehicles", totalVehicles);
        data.put("totalFine", totalFine);
        data.put("recentChallans", challans);

        return data;
    }
}