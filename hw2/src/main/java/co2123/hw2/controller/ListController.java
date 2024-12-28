package co2123.hw2.controller;
import co2123.hw2.Hw2Application;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class ListController {
    Hw2Application hw2Application;

    @GetMapping("/listBakery")
    public String listBakery(Model model) {
        model.addAttribute("data", Hw2Application.bakeryList);
        return "list";
    }

    @GetMapping("/listBread")
    public String listBread(Model model) {
        model.addAttribute("data", Hw2Application.breadList);
        return "list";
    }

    @GetMapping("/listIngredient")
    public String listIngredient(Model model) {
        model.addAttribute("data", Hw2Application.ingredientList);
        return "list";
    }
}
