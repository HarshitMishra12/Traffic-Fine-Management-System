package com.harshit.traffic_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Challan {

    @Id
    private int id;

    private String vehicleNumber;
    private String offenseType;
    private int fineAmount;
    private String status;

    public Challan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }


    public String getOffenseType() {
        return offenseType;
    }

    public void setOffenseType(String offenseType) {
        this.offenseType = offenseType;
    }


    public int getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(int fineAmount) {
        this.fineAmount = fineAmount;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}