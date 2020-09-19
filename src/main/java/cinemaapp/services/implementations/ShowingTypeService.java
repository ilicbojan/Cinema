package cinemaapp.services.implementations;

import cinemaapp.models.ShowingType;
import cinemaapp.repositories.IShowingTypeRepository;
import cinemaapp.services.interfaces.IShowingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowingTypeService implements IShowingTypeService {

    @Autowired
    private IShowingTypeRepository showingTypeRepository;

    @Override
    public List<ShowingType> getAll() {
        return showingTypeRepository.findAll();
    }
}
