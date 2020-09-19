package cinemaapp.services.interfaces;

import cinemaapp.models.City;

import java.util.List;
import java.util.Optional;

public interface ICityService {
    List<City> getAll();
    City save(City city);
    Optional<City> getById(long id);
    void deleteById(long id);
    City update(City city);
}
