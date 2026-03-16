package com.harshit.traffic_system.controller;

import com.harshit.traffic_system.model.Offense;
import com.harshit.traffic_system.repository.OffenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offenses")
public class OffenseController {

    @Autowired
    private OffenseRepository repository;

    @PostMapping
    public Offense addOffense(@RequestBody Offense offense){
        return repository.save(offense);
    }

    @GetMapping
    public List<Offense> getOffenses(){
        return repository.findAll();
    }
}