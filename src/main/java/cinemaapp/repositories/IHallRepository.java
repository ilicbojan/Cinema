package cinemaapp.repositories;

import cinemaapp.models.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHallRepository extends JpaRepository<Hall, Long> {
    Hall findByName(String name);
}
