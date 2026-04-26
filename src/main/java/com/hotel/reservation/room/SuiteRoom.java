package com.hotel.reservation.room;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SUITE")
public class SuiteRoom extends Room {

    private static final double CLEANING_FEE = 1500.0;

    public SuiteRoom() {}

    @Override
    public double calculatePrice(int nights) {
        // 60% premium plus a flat cleaning fee
        return (getCategory().getBasePrice() * nights * 1.6) + CLEANING_FEE;
    }
}