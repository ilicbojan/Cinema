package cinemaapp.services.implementations;

import cinemaapp.models.Reservation;
import cinemaapp.repositories.IReservationRepository;
import cinemaapp.services.interfaces.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements IReservationService {

    @Autowired
    private IReservationRepository reservationRepository;

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getByUser_UsernameOrderByShowing_DateDesc(String username) {
        return reservationRepository.findByUser_UsernameOrderByShowing_DateDesc(username);
    }

    @Override
    public List<Reservation> getByShowing_Id(long id) {
        return reservationRepository.findByShowing_Id(id);
    }

    @Override
    public List<Reservation> getByIsPayed(boolean isPayed) {
        return reservationRepository.findByIsPayed(isPayed);
    }

    @Override
    public Reservation getById(long id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public Reservation save(Reservation reservation) {
        Reservation persistedReservation = reservationRepository.save(reservation);

        return persistedReservation;
    }

    @Override
    public Reservation update(Reservation reservation) {
        Reservation persistedReservation = reservationRepository.save(reservation);

        return persistedReservation;
    }

    @Override
    public void deleteById(long id) {
        reservationRepository.deleteById(id);
    }
}
