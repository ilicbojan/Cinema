package cinemaapp.repositories;

import cinemaapp.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByHall_IdOrderByNumberAsc(long hallId);
}
