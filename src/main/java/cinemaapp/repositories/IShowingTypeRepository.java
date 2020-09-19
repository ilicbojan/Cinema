package cinemaapp.repositories;

import cinemaapp.models.ShowingType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShowingTypeRepository extends JpaRepository<ShowingType, Long> {
}
