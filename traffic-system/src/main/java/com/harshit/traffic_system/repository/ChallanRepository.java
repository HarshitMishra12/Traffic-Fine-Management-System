package com.harshit.traffic_system.repository;

import com.harshit.traffic_system.model.Challan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChallanRepository extends JpaRepository<Challan, Integer> {

    List<Challan> findByVehicleNumber(String vehicleNumber);

}