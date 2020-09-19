package cinemaapp.controllers;

import cinemaapp.models.City;
import cinemaapp.services.implementations.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cities")
public class CitiesController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public String getAll(Model model) {
        List<City> cities = cityService.getAll();

        model.addAttribute("cities", cities);

        return "cities/index";
    }

    @GetMapping("/{id}}")
    public City get(@PathVariable Long id) throws Exception {
        return cityService.getById(id).orElseThrow(Exception::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City create(@RequestBody City city) {
        return cityService.save(city);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        cityService.getById(id).orElseThrow(Exception::new);

        cityService.deleteById(id);
    }

    @PutMapping("/{id}")
    public City update(@RequestBody City city, @PathVariable Long id) throws Exception {
        if (city.getId() != id) {
            throw new Exception("Error");
        }

        cityService.getById(id).orElseThrow(Exception::new);

        return cityService.save(city);
    }
}
