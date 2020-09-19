package cinemaapp.repositories;

import cinemaapp.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser_UsernameOrderByShowing_DateDesc(String username);
    List<Reservation> findByShowing_Id(long id);
    List<Reservation> findByIsPayed(boolean isPayed);
}
