package com.harshit.traffic_system.repository;

import com.harshit.traffic_system.model.Offense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffenseRepository extends JpaRepository<Offense, String> {

}