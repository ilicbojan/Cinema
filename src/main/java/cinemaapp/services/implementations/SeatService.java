package cinemaapp.services.implementations;

import cinemaapp.models.Seat;
import cinemaapp.repositories.ISeatRepository;
import cinemaapp.services.interfaces.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService implements ISeatService {

    @Autowired
    private ISeatRepository seatRepository;

    @Override
    public Seat save(Seat seat) {
        Seat persistedSeat = seatRepository.save(seat);

        return persistedSeat;
    }

    @Override
    public Seat getById(long id) {
        return seatRepository.findById(id).get();
    }

    @Override
    public List<Seat> getAll() {
        return seatRepository.findAll();
    }

    @Override
    public List<Seat> getByHall_IdOrderByNumberAsc(long hallId) {
        return seatRepository.findByHall_IdOrderByNumberAsc(hallId);
    }
}
