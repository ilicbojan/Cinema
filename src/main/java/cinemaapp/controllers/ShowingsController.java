package cinemaapp.controllers;

import cinemaapp.dto.SearchDto;
import cinemaapp.dto.ShowingDto;
import cinemaapp.models.*;
import cinemaapp.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Controller
public class ShowingsController {

    @Autowired
    private IShowingService showingService;

    @Autowired
    private ICinemaService cinemaService;

    @Autowired
    private IMovieService movieService;

    @Autowired
    private IHallService hallService;

    @Autowired
    private IShowingTypeService showingTypeService;

    @Autowired
    private IReservationService reservationService;

    @GetMapping("/showings")
    public String getAll(Model model) {
        List<Cinema> cinemas = cinemaService.getAll();
        List<Movie> movies = movieService.getAll();

        model.addAttribute("search", new SearchDto());
        model.addAttribute("cinemas", cinemas);
        model.addAttribute("movies", movies);
        model.addAttribute("minDate", LocalDate.now().toString());

        return "showings/index";
    }

    @PostMapping("/showings/search")
    public String search(SearchDto search, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "showings/index";
        }

        List<Showing> showings = showingService.getByCinemaIdAndMovieIdAndDateAndMovieIsShowing(search.getCinemaId(), search.getMovieId(), LocalDate.parse(search.getDate()));

        if (showings.size() == 0) {
            redirectAttributes.addFlashAttribute("noShowings", showings);
        }

        redirectAttributes.addFlashAttribute("showings", showings);

        return "redirect:/showings";
    }

    @GetMapping("/admin/showings")
    public String getAllAdmin(Model model)
    {
        List<Showing> showings = showingService.getAll();

        model.addAttribute("showings", showings);

        return "showings/list";
    }

    @GetMapping("/showings/{id}")
    public String get(Model model, @PathVariable Long id) {
        Optional<Showing> showing = showingService.getById(id);

        model.addAttribute("showing", showing.get());

        return "showings/details";
    }

    @GetMapping("/admin/showings/create")
    public String create(Model model) {
        List<Movie> movies = movieService.getAll();
        List<Hall> halls = hallService.getAll();
        List<ShowingType> types = showingTypeService.getAll();

        model.addAttribute("showingDto", new ShowingDto());
        model.addAttribute("movies", movies);
        model.addAttribute("halls", halls);
        model.addAttribute("types", types);
        model.addAttribute("minDate", LocalDate.now().toString());

        return "showings/create";
    }

    @PostMapping("/admin/showings/save")
    public String store(@Valid ShowingDto showingDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        LocalDate date = LocalDate.parse(showingDto.getDate());
        LocalTime time = LocalTime.parse(showingDto.getTime());

        Showing existingShowing = showingService.getByHall_IdAndDateAndTime(showingDto.getHall().getId(), date, time);

        if (existingShowing != null) {
            List<Movie> movies = movieService.getAll();
            List<Hall> halls = hallService.getAll();
            List<ShowingType> types = showingTypeService.getAll();

            model.addAttribute("movies", movies);
            model.addAttribute("halls", halls);
            model.addAttribute("types", types);

            bindingResult.rejectValue("time", "time.occupied", "Hall is occupied for selected time. Try another one.");
        }

        if (bindingResult.hasErrors()) {
            return "showings/create";
        }
        else {
            Showing showing = new Showing();
            showing.setHall(showingDto.getHall());
            showing.setMovie(showingDto.getMovie());
            showing.setType(showingDto.getType());
            showing.setPrice(showingDto.getPrice());
            showing.setDate(date);
            showing.setTime(time);

            showingService.save(showing);

            redirectAttributes.addFlashAttribute("isCreated", true);

            return "redirect:/admin/showings";
        }
    }

    @GetMapping("/admin/showings/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        Showing showing = showingService.getById(id).get();
        ShowingDto showingDto = new ShowingDto();
        showingDto.setId(showing.getId());
        showingDto.setHall(showing.getHall());
        showingDto.setMovie(showing.getMovie());
        showingDto.setType(showing.getType());
        showingDto.setDate(showing.getDate().toString());
        showingDto.setTime(showing.getTime().toString());
        showingDto.setPrice(showing.getPrice());

        List<Movie> movies = movieService.getAll();
        List<Hall> halls = hallService.getAll();
        List<ShowingType> types = showingTypeService.getAll();

        model.addAttribute("showingDto", showingDto);
        model.addAttribute("movies", movies);
        model.addAttribute("halls", halls);
        model.addAttribute("types", types);
        model.addAttribute("minDate", LocalDate.now().toString());

        return "showings/edit";
    }

    @PostMapping("/admin/showings/update")
    public String update(@Valid ShowingDto showingDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        LocalDate date = LocalDate.parse(showingDto.getDate());
        LocalTime time = LocalTime.parse(showingDto.getTime());

        Showing existingShowing = showingService.getByHall_IdAndDateAndTime(showingDto.getHall().getId(), date, time);

        if (existingShowing != null && existingShowing.getId() != showingDto.getId()) {
            List<Movie> movies = movieService.getAll();
            List<Hall> halls = hallService.getAll();
            List<ShowingType> types = showingTypeService.getAll();

            model.addAttribute("movies", movies);
            model.addAttribute("halls", halls);
            model.addAttribute("types", types);

            bindingResult.rejectValue("time", "time.occupied", "Hall is occupied for selected time. Try another one.");
        }

        if (bindingResult.hasErrors()) {
            return "showings/edit";
        }
        else {
            Showing showing = new Showing();
            showing.setId(showingDto.getId());
            showing.setHall(showingDto.getHall());
            showing.setMovie(showingDto.getMovie());
            showing.setType(showingDto.getType());
            showing.setPrice(showingDto.getPrice());
            showing.setDate(date);
            showing.setTime(time);

            showingService.update(showing);

            redirectAttributes.addFlashAttribute("isUpdated", true);

            return "redirect:/admin/showings/edit/" +showing.getId();
        }
    }

    @GetMapping("/admin/showings/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        showingService.deleteById(id);

        redirectAttributes.addFlashAttribute("isDeleted", true);

        return "redirect:/admin/showings";
    }

    @GetMapping("/admin/showings/{id}/reservations")
    public String reservations(@PathVariable long id, Model model) {
        List<Reservation> reservations = reservationService.getByShowing_Id(id);
        Showing showing = showingService.getById(id).get();

        if (reservations.isEmpty()) {
            model.addAttribute("noReservations", true);
        }

        model.addAttribute("reservations", reservations);
        model.addAttribute("showing", showing);

        return "showings/reservations";
    }
}
