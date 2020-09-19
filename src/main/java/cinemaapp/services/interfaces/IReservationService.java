package cinemaapp.services.interfaces;

import cinemaapp.models.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> getAll();
    List<Reservation> getByUser_UsernameOrderByShowing_DateDesc(String username);
    List<Reservation> getByShowing_Id(long id);
    List<Reservation> getByIsPayed(boolean isPayed);
    Reservation getById(long id);
    Reservation save(Reservation reservation);
    Reservation update(Reservation reservation);
    void deleteById(long id);
}
