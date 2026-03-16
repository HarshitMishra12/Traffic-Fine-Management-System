package com.harshit.traffic_system.repository;

import com.harshit.traffic_system.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}