package cinemaapp.services.interfaces;

import cinemaapp.models.Ticket;

import java.util.List;

public interface ITicketService {
    List<Ticket> getByShowing_Id(long id);
    List<Ticket> getByReservation_IsPayed(boolean isPayed);
    Ticket getById(long id);
    Ticket save(Ticket ticket);
    void deleteById(long id);
}
