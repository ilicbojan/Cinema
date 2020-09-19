package cinemaapp.services.interfaces;

import cinemaapp.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAll();
    List<User> getByRoles(String roles);
    List<User> getByClubs_Id(long id);
    Optional<User> getById(long id);
    User getByUsername(String username);
    User getByEmail(String email);
    User save(User user);
    User update(User user);
    void deleteById(long id);
}
