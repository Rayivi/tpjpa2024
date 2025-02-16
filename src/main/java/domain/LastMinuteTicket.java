package domain;

import jakarta.persistence.Entity;

@Entity
public class LastMinuteTicket extends Ticket {
    private boolean reservedSeat;

    public LastMinuteTicket( int numPlace, String choixEnvoie, Concert concert, boolean reservedSeat) {
        super( numPlace, choixEnvoie, concert);
        this.reservedSeat = reservedSeat;
    }

    public boolean isReservedSeat() {
        return reservedSeat;
    }

    public void setReservedSeat(boolean reservedSeat) {
        this.reservedSeat = reservedSeat;
    }
}