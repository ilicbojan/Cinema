package cinemaapp.services.implementations;

import cinemaapp.models.Movie;
import cinemaapp.repositories.IMovieRepository;
import cinemaapp.services.interfaces.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private IMovieRepository movieRepository;

    @Override
    public List<Movie> getAll() {
        return this.movieRepository.findAllByOrderByTitleAsc();
    }

    @Override
    public Movie save(Movie movie) {
        Movie persistedMovie = this.movieRepository.save(movie);

        return persistedMovie;
    }

    @Override
    public Optional<Movie> getById(long id) {
        return this.movieRepository.findById(id);
    }

    @Override
    public Movie getByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    @Override
    public List<Movie> getByShowings_DateGreaterThanEqual(LocalDate date) {
        return movieRepository.findByShowings_DateGreaterThanEqual(date);
    }

    @Override
    public List<Movie> getByIsShowingTrue() {
        return movieRepository.findByIsShowingTrue();
    }

    @Override
    public void deleteById(long id) {
        this.movieRepository.deleteById(id);
    }

    @Override
    public Movie update(Movie movie) {
        Movie persistedMovie = this.movieRepository.save(movie);

        return persistedMovie;
    }
}
