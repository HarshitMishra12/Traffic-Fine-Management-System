package com.harshit.traffic_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Offense {

    @Id
    private String offenseName;
    private int fine;

    public Offense() {}

    public String getOffenseName() {
        return offenseName;
    }

    public void setOffenseName(String offenseName) {
        this.offenseName = offenseName;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
}