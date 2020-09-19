package cinemaapp.repositories;

import cinemaapp.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByShowing_Id(long id);
    List<Ticket> findByReservation_IsPayed(boolean isPayed);
}
