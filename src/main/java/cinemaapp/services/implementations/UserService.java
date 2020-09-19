package cinemaapp.services.implementations;

import cinemaapp.models.User;
import cinemaapp.repositories.IUserRepository;
import cinemaapp.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getByRoles(String roles) {
        return userRepository.findByRoles(roles);
    }

    @Override
    public List<User> getByClubs_Id(long id) {
        return userRepository.findByClubs_Id(id);
    }

    @Override
    public Optional<User> getById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        User persistedUser = userRepository.save(user);

        return persistedUser;
    }

    @Override
    public User update(User user) {
        User persistedUser = userRepository.save(user);

        return persistedUser;
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
