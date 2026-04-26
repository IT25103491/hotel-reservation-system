package com.hotel.reservation.room;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DELUXE")
public class DeluxeRoom extends Room {

    public DeluxeRoom() {}

    @Override
    public double calculatePrice(int nights) {
        // 30% premium over base price
        return getCategory().getBasePrice() * nights * 1.3;
    }
}