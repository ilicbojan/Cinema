package cinemaapp.repositories;

import cinemaapp.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClubRepository extends JpaRepository<Club, Long> {
    List<Club> findByUsers_Username(String username);
}
