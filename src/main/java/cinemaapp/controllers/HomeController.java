package cinemaapp.controllers;

import cinemaapp.models.*;
import cinemaapp.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IMovieService movieService;

    @Autowired
    private ICinemaService cinemaService;

    @Autowired
    private ICityService cityService;

    @Autowired
    private IHallService hallService;

    @Autowired
    private ISeatService seatService;

    @Autowired
    private IShowingService showingService;

    @Autowired
    private IReservationService reservationService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IClubService clubService;

    @Autowired
    private ITicketService ticketService;

    @GetMapping("/")
    public String home(Model model) {
        List<Movie> movies = movieService.getAll();
        List<Cinema> cinemas = cinemaService.getAll();

        model.addAttribute("movies", movies.subList(0, 2));
        model.addAttribute("cinemas", cinemas.subList(0, 3));

        return "home/index";
    }

    @GetMapping("/admin")
    public String admin(Model model) {

        return "home/admin";
    }

    @GetMapping("/manager")
    public String manager(Model model) {
        List<Cinema> cinemas = cinemaService.getAll();
        List<City> cities = cityService.getAll();
        List<Hall> halls = hallService.getAll();
        List<Seat> seats = seatService.getAll();
        List<Movie> movies = movieService.getAll();
        List<Movie> showingMovies = movieService.getByIsShowingTrue();
        List<Showing> showings = showingService.getAll();
        List<Showing> activeShowings = showingService.getByDateGreaterThanEqual();
        List<Reservation> reservations = reservationService.getByIsPayed(false);
        List<Ticket> reservedTickets = ticketService.getByReservation_IsPayed(false);
        List<Reservation> soldReservations = reservationService.getByIsPayed(true);
        List<Ticket> soldTickets = ticketService.getByReservation_IsPayed(true);
        List<User> users = userService.getByRoles("ROLE_USER");
        List<Club> clubs = clubService.getAll();
        List<User> admins = userService.getByRoles("ROLE_ADMIN");
        List<User> managers = userService.getByRoles("ROLE_MANAGER");
        List<User> premiumMembers = userService.getByClubs_Id(1);
        List<User> standardMembers = userService.getByClubs_Id(3);
        List<User> bonusCards = userService.getByClubs_Id(2);

        float totalIncome = 0;
        float thisMonth = 0;
        float lastSevenDays = 0;
        float today = 0;

        for (Reservation res : soldReservations) {
            totalIncome += res.getTotalPrice();

            if (res.getShowing().getDate().getYear() == LocalDate.now().getYear()) {
                Period period = Period.between(res.getCreatedDate(), LocalDate.now());
                int diff = period.getDays();

                if (res.getCreatedDate().getMonthValue() == LocalDate.now().getMonthValue()) {
                    thisMonth += res.getTotalPrice();
                }

                if (diff <= 7 && diff >= 0) {
                    lastSevenDays += res.getTotalPrice();
                }

                if (res.getCreatedDate().isEqual(LocalDate.now())) {
                    today += res.getTotalPrice();
                }
            }
        }

        model.addAttribute("cinemas", cinemas.size());
        model.addAttribute("cities", cities.size());
        model.addAttribute("halls", halls.size());
        model.addAttribute("seats", seats.size());
        model.addAttribute("movies", movies.size());
        model.addAttribute("showingMovies", showingMovies.size());
        model.addAttribute("showings", showings.size());
        model.addAttribute("activeShowings", activeShowings.size());
        model.addAttribute("reservations", reservations.size());
        model.addAttribute("reservedTickets", reservedTickets.size());
        model.addAttribute("soldReservations", soldReservations.size());
        model.addAttribute("soldTickets", soldTickets.size());
        model.addAttribute("totalIncome", totalIncome);
        model.addAttribute("thisMonth", thisMonth);
        model.addAttribute("lastSevenDays", lastSevenDays);
        model.addAttribute("today", today);
        model.addAttribute("users", users.size());
        model.addAttribute("clubs", clubs.size());
        model.addAttribute("admins", admins.size());
        model.addAttribute("managers", managers.size());
        model.addAttribute("premiumMembers", premiumMembers.size());
        model.addAttribute("standardMembers", standardMembers.size());
        model.addAttribute("bonusCards", bonusCards.size());

        return "home/manager";
    }
}
