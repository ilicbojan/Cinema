package cinemaapp.services.implementations;

import cinemaapp.models.Club;
import cinemaapp.repositories.IClubRepository;
import cinemaapp.services.interfaces.IClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService implements IClubService {

    @Autowired
    private IClubRepository clubRepository;

    @Override
    public List<Club> getAll() {
        return clubRepository.findAll();
    }

    @Override
    public Club getById(long id) {
        return clubRepository.findById(id).get();
    }

    @Override
    public List<Club> getByUsers_Username(String username) {
        return clubRepository.findByUsers_Username(username);
    }
}
