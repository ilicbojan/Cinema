package cinemaapp.controllers;

import cinemaapp.models.Club;
import cinemaapp.models.User;
import cinemaapp.services.interfaces.IClubService;
import cinemaapp.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class ClubsController {

    @Autowired
    private IClubService clubService;

    @Autowired
    private IUserService userService;

    @GetMapping("/clubs")
    public String getAll(Model model, Principal principal) {
        List<Club> clubs = clubService.getAll();

        if (principal != null) {
            User user = userService.getByUsername(principal.getName());

            model.addAttribute("user", user);
        }

        model.addAttribute("clubs", clubs);

        return "clubs/index";
    }

    @GetMapping("/clubs/{id}/join")
    public String join(@PathVariable long id, Model model, Principal principal, RedirectAttributes redirectAttributes) {
        User user = userService.getByUsername(principal.getName());
        Club club = clubService.getById(id);

        user.getClubs().add(club);
        userService.save(user);

        redirectAttributes.addFlashAttribute("isJoined", true);

        return "redirect:/clubs";
    }
}
