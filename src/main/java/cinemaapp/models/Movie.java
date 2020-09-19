package cinemaapp.models;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private long id;

    @NotNull(message = "Title is required")
    @Size(max = 30, message = "Name must be less than 30 characters")
    @Column(name = "title", unique = true)
    private String title;

    @NotNull(message = "Duration is required")
    @Min(value = 1, message = "Duration must be grater than 1 minute")
    @Max(value = 600, message = "Duration must be less than 600 minutes")
    @Column(name = "duration")
    private int duration;

    @NotNull(message = "Year is required")
    @Min(value = 1600, message = "Year must be grater than 1600")
    @Max(value = 2100, message = "Duration must be less than 2100")
    @Column(name = "year")
    private int year;

    @NotNull(message = "Rating is required")
    @Min(value = 1, message = "Rating must be grater than 0")
    @Max(value = 10, message = "Rating must be less than 11")
    @Column(name = "rating")
    private double rating;

    @NotNull(message = "Director is required")
    @Size(max = 80, message = "Director must be less than 80 characters")
    @Column(name = "director")
    private String director;

    @NotNull(message = "Writer is required")
    @Size(max = 80, message = "Writer must be less than 80 characters")
    @Column(name = "writer")
    private String writer;

    @NotNull(message = "Stars are required")
    @Size(max = 80, message = "Stars must be less than 80 characters")
    @Column(name = "stars")
    private String stars;

    @NotNull(message = "Description is required")
    @Size(max = 800, message = "Description must be less than 700 characters")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Image is required")
    @Column(name = "image")
    private String image;

    @NotNull(message = "Trailer URL is required")
    @URL(message = "Trailer URL must be URL")
    @Column(name = "trailer_URL")
    private String trailerURL;

    @NotNull(message = "Genre is required")
    @Size(max = 50, message = "Genre must be less than 50 characters")
    @Column(name = "genre")
    private String genre;

    @NotNull(message = "Country is required")
    @Size(max = 30, message = "Country must be less than 30 characters")
    @Column(name = "country")
    private String country;

    @Column(name = "is_showing")
    private boolean isShowing;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<Showing> showings;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTrailerURL() {
        return trailerURL;
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isShowing() {
        return isShowing;
    }

    public void setShowing(boolean showing) {
        isShowing = showing;
    }

    public Set<Showing> getShowings() {
        return showings;
    }

    public void setShowings(Set<Showing> showings) {
        this.showings = showings;
    }
}
