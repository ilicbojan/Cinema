package cinemaapp.models;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private long id;

    @ManyToOne
    private Reservation reservation;

    @ManyToOne
    private Seat seat;

    @ManyToOne
    private Showing showing;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Showing getShowing() {
        return showing;
    }

    public void setShowing(Showing showing) {
        this.showing = showing;
    }
}
