package com.harshit.traffic_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vehicle {

    @Id
    private String vehicleNumber;
    private String ownerName;
    private String phone;
    private String vehicleType;

    public Vehicle(){}

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }
}