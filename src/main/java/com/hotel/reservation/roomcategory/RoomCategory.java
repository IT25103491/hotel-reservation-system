package com.hotel.reservation.roomcategory;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "room_categories")
public class RoomCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 500)
    private String description;

    @Positive(message = "Base price must be greater than 0")
    @Column(nullable = false)
    private double basePrice;

    private String amenities;

    public RoomCategory() {}

    public RoomCategory(String name, String description, double basePrice, String amenities) {
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.amenities = amenities;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getBasePrice() { return basePrice; }
    public void setBasePrice(double basePrice) { this.basePrice = basePrice; }

    public String getAmenities() { return amenities; }
    public void setAmenities(String amenities) { this.amenities = amenities; }
}