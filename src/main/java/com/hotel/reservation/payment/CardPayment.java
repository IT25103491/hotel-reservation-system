package com.hotel.reservation.payment;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CARD")
public class CardPayment extends Payment {

    private String cardLastFour;     // store only last 4 digits (PCI best practice)
    private String cardholderName;
    private String cardType;          // VISA, MASTERCARD, etc.

    public CardPayment() {
        super();
    }

    @Override
    public boolean processPayment() {
        // Simulate card processing with validation
        if (getAmount() <= 0) {
            setStatus("FAILED");
            return false;
        }
        if (cardLastFour == null || cardLastFour.length() != 4) {
            setStatus("FAILED");
            return false;
        }
        if (cardholderName == null || cardholderName.isBlank()) {
            setStatus("FAILED");
            return false;
        }
        // In a real system: call payment gateway here.
        // For our project: simulate success.
        setStatus("COMPLETED");
        return true;
    }

    // Helper for the controller — extracts last 4 from full card number
    public void setFullCardNumber(String fullNumber) {
        if (fullNumber != null && fullNumber.length() >= 4) {
            this.cardLastFour = fullNumber.substring(fullNumber.length() - 4);
        }
    }

    public String getCardLastFour() { return cardLastFour; }
    public void setCardLastFour(String cardLastFour) { this.cardLastFour = cardLastFour; }

    public String getCardholderName() { return cardholderName; }
    public void setCardholderName(String cardholderName) { this.cardholderName = cardholderName; }

    public String getCardType() { return cardType; }
    public void setCardType(String cardType) { this.cardType = cardType; }
}