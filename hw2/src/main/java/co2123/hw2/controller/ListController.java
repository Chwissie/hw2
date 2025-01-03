package co2123.hw2.controller;
import co2123.hw2.Hw2Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import co2123.hw2.repo.BakeryRepository;
import co2123.hw2.repo.BreadRepository;
import co2123.hw2.repo.IngredientRepository;

@Controller
public class ListController {

    @Autowired
    private BakeryRepository bakeryRepository;

    @Autowired
    private BreadRepository breadRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("/listBakery")
    public String listBakery(Model model) {
        model.addAttribute("data", bakeryRepository.findAll());
        return "list";
    }

    @GetMapping("/listBread")
    public String listBread(Model model) {
        model.addAttribute("data", breadRepository.findAll());
        return "list";
    }

    @GetMapping("/listIngredient")
    public String listIngredient(Model model) {
        model.addAttribute("data", ingredientRepository.findAll());
        return "list";
    }
}
