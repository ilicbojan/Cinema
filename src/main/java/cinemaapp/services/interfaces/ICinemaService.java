package cinemaapp.services.interfaces;

import cinemaapp.models.Cinema;

import java.util.List;
import java.util.Optional;

public interface ICinemaService {
    List<Cinema> getAll();
    Cinema save(Cinema cinema);
    Optional<Cinema> getById(long id);
    Cinema getByName(String name);
    void deleteById(long id);
    Cinema update(Cinema cinema);
}
