package com.hotel.reservation.room;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("NON_AC")
public class NonAcRoom extends Room {

    public NonAcRoom() {}

    @Override
    public double calculatePrice(int nights) {
        // Straight base rate — no premium
        return getCategory().getBasePrice() * nights;
    }
}