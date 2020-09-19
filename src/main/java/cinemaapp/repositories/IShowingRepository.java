package cinemaapp.repositories;

import cinemaapp.models.Showing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IShowingRepository extends JpaRepository<Showing, Long> {
    List<Showing> findByHall_Cinema_IdAndMovie_IdAndDateAndMovie_IsShowing(long cinemaId, long movieId, LocalDate date, boolean isShowing);
    List<Showing> findByMovie_IdAndAndMovie_IsShowingAndDateGreaterThanEqualOrderByDateAscTimeAsc(long movieId, boolean isShowing, LocalDate date);
    List<Showing> findByHall_Cinema_IdAndDateGreaterThanEqualOrderByDateAscTimeAsc(long cinemaId, LocalDate date);
    List<Showing> findByHall_Cinema_IdOrderByDateDesc(long cinemaId);
    List<Showing> findByDateGreaterThanEqual(LocalDate date);

    Showing findByHall_IdAndDateAndTime(long hallId, LocalDate date, LocalTime time);
}
