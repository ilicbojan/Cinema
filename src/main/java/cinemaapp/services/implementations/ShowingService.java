package cinemaapp.services.implementations;

import cinemaapp.models.Showing;
import cinemaapp.repositories.IShowingRepository;
import cinemaapp.services.interfaces.IShowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ShowingService implements IShowingService {

    @Autowired
    private IShowingRepository showingRepository;

    @Override
    public List<Showing> getAll() {
        return this.showingRepository.findAll();
    }

    @Override
    public Optional<Showing> getById(long id) {
        return this.showingRepository.findById(id);
    }

    @Override
    public List<Showing> getByCinemaIdAndMovieIdAndDateAndMovieIsShowing(long cinemaId, long movieId, LocalDate date) {
        return showingRepository.findByHall_Cinema_IdAndMovie_IdAndDateAndMovie_IsShowing(cinemaId, movieId, date, true);
    }

    @Override
    public List<Showing> getByMovie_IdAndMovie_IsShowingAndDateGreaterThanEqualOrderByDateAsc(long movieId, LocalDate date) {
        return showingRepository.findByMovie_IdAndAndMovie_IsShowingAndDateGreaterThanEqualOrderByDateAscTimeAsc(movieId, true, date);
    }

    @Override
    public List<Showing> getByHall_Cinema_IdAndDateGreaterThanEqualOrderByDateAsc(long cinemaId, LocalDate date) {
        return showingRepository.findByHall_Cinema_IdAndDateGreaterThanEqualOrderByDateAscTimeAsc(cinemaId, date);
    }

    @Override
    public List<Showing> getByHall_Cinema_IdOrderByDateDesc(long cinemaId) {
        return showingRepository.findByHall_Cinema_IdOrderByDateDesc(cinemaId);
    }

    @Override
    public List<Showing> getByDateGreaterThanEqual() {
        return showingRepository.findByDateGreaterThanEqual(LocalDate.now());
    }

    @Override
    public Showing getByHall_IdAndDateAndTime(long hallId, LocalDate date, LocalTime time) {
        return showingRepository.findByHall_IdAndDateAndTime(hallId, date, time);
    }

    @Override
    public Showing save(Showing showing) {
        Showing persistedShowing = this.showingRepository.save(showing);

        return persistedShowing;
    }

    @Override
    public Showing update(Showing showing) {
        Showing persistedShowing = this.showingRepository.save(showing);

        return persistedShowing;
    }

    @Override
    public void deleteById(long id) {
        this.showingRepository.deleteById(id);
    }
}
