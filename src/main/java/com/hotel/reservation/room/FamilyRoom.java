package com.hotel.reservation.room;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("FAMILY")
public class FamilyRoom extends Room {

    private static final double EXTRA_BED_FEE_PER_NIGHT = 800.0;

    @Column(name = "extra_beds")
    private int extraBeds = 1;  // family rooms have at least one extra bed by default

    public FamilyRoom() {}

    @Override
    public double calculatePrice(int nights) {
        // Base rate plus extra-bed fee per night per bed
        double base = getCategory().getBasePrice() * nights;
        double extraBedCost = EXTRA_BED_FEE_PER_NIGHT * extraBeds * nights;
        return base + extraBedCost;
    }

    public int getExtraBeds() { return extraBeds; }
    public void setExtraBeds(int extraBeds) { this.extraBeds = extraBeds; }
}