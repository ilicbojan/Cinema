package cinemaapp.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "seat")
public class Seat {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private long id;

    @NotNull(message = "Row is required")
    @Min(value = 1, message = "Row must be grater than 0")
    @Max(value = 100, message = "Row must be less than 101")
    @Column(name = "row")
    private int row;

    @NotNull(message = "Number is required")
    @Min(value = 1, message = "Number must be grater than 0")
    @Max(value = 400, message = "Number must be less than 401")
    @Column(name = "number")
    private int number;

    @ManyToOne
    private Hall hall;

    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
    private Set<Ticket> tickets;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
