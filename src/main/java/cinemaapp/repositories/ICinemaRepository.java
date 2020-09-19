package cinemaapp.repositories;

import cinemaapp.models.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICinemaRepository extends JpaRepository<Cinema, Long> {
    Cinema findByName(String name);
    List<Cinema> findAllByOrderByNameAsc();

}
