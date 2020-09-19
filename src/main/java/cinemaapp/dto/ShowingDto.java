package cinemaapp.dto;

import cinemaapp.models.Hall;
import cinemaapp.models.Movie;
import cinemaapp.models.ShowingType;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ShowingDto {
    private long id;

    @NotNull(message = "Date is required")
    private String date;

    @NotNull(message = "Time is required")
    private String time;

    @NotNull(message = "Price is required")
    @Min(value = 1, message = "Price must be greater than 0")
    @Max(value = 10000, message = "Price must be less than 10001")
    private float price;

    private Movie movie;

    private Hall hall;

    private ShowingType type;

    public ShowingDto() {}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public ShowingType getType() {
        return type;
    }

    public void setType(ShowingType type) {
        this.type = type;
    }
}
