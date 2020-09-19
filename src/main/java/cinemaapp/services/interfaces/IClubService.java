package cinemaapp.services.interfaces;

import cinemaapp.models.Club;

import java.util.List;

public interface IClubService {
    List<Club> getAll();
    Club getById(long id);
    List<Club> getByUsers_Username(String username);
}
