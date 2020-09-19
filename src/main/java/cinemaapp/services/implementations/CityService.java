package cinemaapp.services.implementations;

import cinemaapp.models.City;
import cinemaapp.repositories.ICityRepository;
import cinemaapp.services.interfaces.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService implements ICityService {

    @Autowired
    private ICityRepository cityRepository;


    @Override
    public List<City> getAll() {
        return this.cityRepository.findAll();
    }

    @Override
    public City save(City city) {
        City persistedCity = this.cityRepository.save(city);

        return persistedCity;
    }

    @Override
    public Optional<City> getById(long id) {
        return this.cityRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        this.cityRepository.deleteById(id);
    }

    @Override
    public City update(City city) {
        City persistedCity = this.cityRepository.save(city);

        return persistedCity;
    }
}
