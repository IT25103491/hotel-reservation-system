package com.hotel.reservation.room;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("STANDARD")
public class StandardRoom extends Room {

    public StandardRoom() {}

    @Override
    public double calculatePrice(int nights) {
        return getCategory().getBasePrice() * nights;
    }
}