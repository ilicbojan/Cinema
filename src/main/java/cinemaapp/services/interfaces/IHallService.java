package cinemaapp.services.interfaces;

import cinemaapp.models.Hall;

import java.util.List;
import java.util.Optional;

public interface IHallService {
    List<Hall> getAll();
    Hall save(Hall hall);
    Hall getByName(String name);
    Optional<Hall> getById(long id);
    void deleteById(long id);
    Hall update(Hall hall);
}
