package cinemaapp.controllers;

import cinemaapp.config.MyUserDetails;
import cinemaapp.models.Club;
import cinemaapp.models.Reservation;
import cinemaapp.models.Ticket;
import cinemaapp.models.User;
import cinemaapp.services.interfaces.IClubService;
import cinemaapp.services.interfaces.IReservationService;
import cinemaapp.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Set;

@Controller
public class UsersController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IReservationService reservationService;

    @Autowired
    private IClubService clubService;

    @GetMapping("/login")
    public String loginForm(Model model, @RequestParam(required = false, defaultValue = "false") Boolean error) {
        model.addAttribute("user", new User());

        if (error) {
            model.addAttribute("error", "Username or password is incorrect");
        }

        return "users/login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        User user = new User();
        user.setRoles("ROLE_USER");

        model.addAttribute("user", user);

        return "users/register";
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        ModelAndView model = new ModelAndView();

        User existingByUsername = userService.getByUsername(user.getUsername());
        if (existingByUsername != null) {
            bindingResult.rejectValue("username", "error.user", "Username already exists");
        }

        User existingByEmail = userService.getByEmail(user.getEmail());
        if (existingByEmail != null) {
            bindingResult.rejectValue("email", "error.user", "Email already exists");
        }

        if (bindingResult.hasErrors()) {
            model.setViewName("users/register");
        }
        else {
            user.setRoles("ROLE_USER");

            userService.save(user);

            redirectAttributes.addFlashAttribute("isRegistered", true);

            model.setViewName("users/login");
        }

        return model;
    }

    @GetMapping("/admin/users")
    public String getAllAdmin(Model model)
    {
        List<User> users = userService.getAll();

        model.addAttribute("users", users);

        return "users/list";
    }

    @GetMapping("/admin/users/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        userService.deleteById(id);

        redirectAttributes.addFlashAttribute("isDeleted", true);

        return "redirect:/admin/users";
    }

    @GetMapping("/profile/edit")
    public String edit(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.getByUsername(username);

        model.addAttribute("user", user);

        return "users/edit";
    }

    @PostMapping("/profile/update")
    public String update(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        User existingByUsername = userService.getByUsername(user.getUsername());
        if (existingByUsername != null && existingByUsername.getId() != user.getId()) {
            bindingResult.rejectValue("username", "error.user", "Username already exists");
        }

        User existingByEmail = userService.getByEmail(user.getEmail());
        if (existingByEmail != null && existingByEmail.getId() != user.getId()) {
            bindingResult.rejectValue("email", "error.user", "Email already exists");
        }

        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        else {
            userService.save(user);

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
            userDetails.setUsername(user.getUsername());

            redirectAttributes.addFlashAttribute("isUpdated", true);

            return "redirect:/profile/edit";
        }
    }

    @GetMapping("/profile/reservations")
    public String getReservations(Model model, Principal principal) {
        List<Reservation> reservations = reservationService.getByUser_UsernameOrderByShowing_DateDesc(principal.getName());

        model.addAttribute("reservations", reservations);

        return "users/reservations";
    }

    @GetMapping("/profile/reservations/{id}/tickets")
    public String getReservations(@PathVariable long id, Model model) {
        Reservation reservation = reservationService.getById(id);
        Set<Ticket> tickets = reservation.getTickets();

        model.addAttribute("reservation", reservation);
        model.addAttribute("tickets", tickets);

        return "users/tickets";
    }

    @GetMapping("/admin/users/create")
    public String create(Model model) {
        model.addAttribute("user", new User());

        return "users/create";
    }

    @PostMapping("/admin/users/save")
    public String store(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        User existingByUsername = userService.getByUsername(user.getUsername());
        if (existingByUsername != null) {
            bindingResult.rejectValue("username", "error.user", "Username already exists");
        }

        User existingByEmail = userService.getByEmail(user.getEmail());
        if (existingByEmail != null) {
            bindingResult.rejectValue("email", "error.user", "Email already exists");
        }

        if (bindingResult.hasErrors()) {
            return "users/create";
        }
        else {
            userService.save(user);

            redirectAttributes.addFlashAttribute("isCreated", true);

            return "redirect:/admin/users";
        }
    }

    @GetMapping("/profile/clubs")
    public String clubs(Model model, Principal principal) {
        List<Club> clubs = clubService.getByUsers_Username(principal.getName());

        model.addAttribute("clubs", clubs);

        return "users/clubs";
    }
}
