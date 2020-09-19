package cinemaapp.services.interfaces;

import cinemaapp.models.Movie;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IMovieService {
    List<Movie> getAll();
    Optional<Movie> getById(long id);
    Movie getByTitle(String title);
    List<Movie> getByShowings_DateGreaterThanEqual(LocalDate date);
    List<Movie> getByIsShowingTrue();
    Movie save(Movie movie);
    Movie update(Movie movie);
    void deleteById(long id);
}
