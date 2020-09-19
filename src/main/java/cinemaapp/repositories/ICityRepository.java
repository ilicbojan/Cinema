package cinemaapp.repositories;

import cinemaapp.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<City, Long> {

}
