package cinemaapp.services.interfaces;

import cinemaapp.models.Showing;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface IShowingService {
    Optional<Showing> getById(long id);
    List<Showing> getAll();
    List<Showing> getByCinemaIdAndMovieIdAndDateAndMovieIsShowing(long cinemaId, long movieId, LocalDate date);
    List<Showing> getByMovie_IdAndMovie_IsShowingAndDateGreaterThanEqualOrderByDateAsc(long movieId, LocalDate date);
    List<Showing> getByHall_Cinema_IdAndDateGreaterThanEqualOrderByDateAsc(long cinemaId, LocalDate date);
    List<Showing> getByHall_Cinema_IdOrderByDateDesc(long cinemaId);
    List<Showing> getByDateGreaterThanEqual();
    Showing getByHall_IdAndDateAndTime(long hallId, LocalDate date, LocalTime time);
    Showing save(Showing showing);
    Showing update(Showing showing);
    void deleteById(long id);
}
