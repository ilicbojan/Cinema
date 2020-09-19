package cinemaapp.repositories;

import cinemaapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findByRoles(String roles);
    List<User> findByClubs_Id(long id);
}
