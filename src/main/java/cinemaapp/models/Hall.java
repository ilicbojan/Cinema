package cinemaapp.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "hall")
public class Hall {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private long id;

    @NotNull(message = "Name is required")
    @Length(max = 30, message = "Name must be less than 30 characters")
    @Column(name = "name", unique = true)
    private String name;

    @NotNull(message = "Seats number is required")
    @Min(value = 50, message = "Seats number must be grater than 49")
    @Max(value = 400, message = "Seats number must be less than 401")
    @Column(name = "seats_number")
    private int seatsNumber;

    @NotNull(message = "Seats in row number required")
    @Min(value = 10, message = "Seats in row must be grater than 9")
    @Max(value = 20, message = "Seats in row must be less than 21")
    @Column(name = "seats_in_row")
    private int seatsInRow;

    @NotNull(message = "Rows number required")
    @Min(value = 1, message = "Rows must be grater than 0")
    @Max(value = 40, message = "Rows must be less than 41")
    @Column(name = "rows")
    private int rows;

    @NotNull(message = "Screen size is required")
    @Min(value = 20, message = "Screen size must be grater than 0")
    @Max(value = 300, message = "Screen size must be less than 301")
    @Column(name = "screen_size")
    private int screenSize;

    @ManyToOne
    private Cinema cinema;

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
    private Set<Showing> showings;

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
    private Set<Seat> seats;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Set<Showing> getShowings() {
        return showings;
    }

    public void setShowings(Set<Showing> showings) {
        this.showings = showings;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    public int getSeatsInRow() {
        return seatsInRow;
    }

    public void setSeatsInRow(int seatsInRow) {
        this.seatsInRow = seatsInRow;
    }
}
