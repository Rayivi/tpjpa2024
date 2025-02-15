package domain;

import jakarta.persistence.Entity;

@Entity
public class PremiumTicket extends Ticket {
    private String additionalBenefits;

    public PremiumTicket( int numPlace, String choixEnvoie, Concert concert, String additionalBenefits) {
        super( numPlace, choixEnvoie, concert);
        this.additionalBenefits = additionalBenefits;
    }

    public String getAdditionalBenefits() {
        return additionalBenefits;
    }

    public void setAdditionalBenefits(String additionalBenefits) {
        this.additionalBenefits = additionalBenefits;
    }
}