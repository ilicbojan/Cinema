package cinemaapp.dto;

import org.hibernate.validator.constraints.URL;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MovieDto {
    @NotNull(message = "Title is required")
    @Size(max = 30, message = "Name must be less than 30 characters")
    private String title;

    @NotNull(message = "Duration is required")
    @Min(value = 1, message = "Duration must be grater than 1 minute")
    @Max(value = 600, message = "Duration must be less than 600 minutes")
    private int duration;

    @NotNull(message = "Year is required")
    @Min(value = 1600, message = "Year must be grater than 1600")
    @Max(value = 2100, message = "Duration must be less than 2100")
    private int year;

    @NotNull(message = "Rating is required")
    @Min(value = 1, message = "Rating must be grater than 0")
    @Max(value = 10, message = "Rating must be less than 11")
    private double rating;

    @NotNull(message = "Director is required")
    @Size(max = 80, message = "Director must be less than 80 characters")
    private String director;

    @NotNull(message = "Writer is required")
    @Size(max = 80, message = "Writer must be less than 80 characters")
    private String writer;

    @NotNull(message = "Stars are required")
    @Size(max = 80, message = "Stars must be less than 80 characters")
    private String stars;

    @NotNull(message = "Description is required")
    @Size(max = 800, message = "Description must be less than 700 characters")
    private String description;

    @NotNull(message = "Image is required")
    private MultipartFile image;

    @NotNull(message = "Trailer URL is required")
    @URL(message = "Trailer URL must be URL")
    private String trailerURL;

    @NotNull(message = "Genre is required")
    @Size(max = 50, message = "Genre must be less than 50 characters")
    private String genre;

    @NotNull(message = "Country is required")
    @Size(max = 30, message = "Country must be less than 30 characters")
    private String country;

    private boolean isShowing;

    public MovieDto() {}

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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
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
}
