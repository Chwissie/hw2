package co2123.hw2.controller;

import co2123.hw2.repo.BakeryRepository;
import co2123.hw2.repo.BreadRepository;
import co2123.hw2.repo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import co2123.hw2.model.Bakery;
import co2123.hw2.model.Bread;
import co2123.hw2.model.Ingredient;


@Controller
public class DeleteController {

    @Autowired
    private BakeryRepository bakeryRepository;

    @Autowired
    private BreadRepository breadRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("/deleteBakery")
    public String deleteBakery(@RequestParam int id) {
        if (bakeryRepository.findById(id).isPresent()) {
            bakeryRepository.delete(bakeryRepository.findById(id).get());
        }
        return "redirect:/";
    }

    @GetMapping("/deleteBread")
    public String deleteBread(@RequestParam String name) {
        if (breadRepository.findById(name).isPresent()) { //checks if bread exists
            Bread bread = breadRepository.findById(name).get(); //gets bread

            for (Bakery bakery : bread.getBakeries()) { //remove all breads first (gets rid of references)
                bakery.getBreads().remove(bread);
                bakeryRepository.save(bakery); //save so references removed

                if (bakery.getNewest() == null) { break; } //if there isn't a newest bakery, cut the loop and delete bread

                if (bakery.getNewest().getName().equals(name)) { //if there is, remove the reference
                    bakery.setNewest(null);
                    bakeryRepository.save(bakery); //save once again
                }
            }

            breadRepository.delete(bread); //delete all bread
        }
        return "redirect:/";
    }

    @GetMapping("/deleteIngredient")
    public String deleteIngredient(@RequestParam int identifier) {
        if (ingredientRepository.findById(identifier).isPresent()) {
            Ingredient ingredient = ingredientRepository.findById(identifier).get();

            // Update all breads that use this ingredient as filling
            for (Bread bread : breadRepository.findAll()) {
                if (bread.getFilling() != null && bread.getFilling().getIdentifier() == identifier) {//checks if not null and also the same identifier
                    bread.setFilling(null);
                    breadRepository.save(bread); // Save bread
                }

                // Remove ingredient from bread ingredient list
                if (!bread.getIngredients().isEmpty()) {
                    bread.getIngredients().removeIf(breadIngredient -> breadIngredient.getIdentifier() == identifier);
                    breadRepository.save(bread);
                }
            }


            ingredientRepository.delete(ingredient); //delete ingredient
        }
        return "redirect:/";
    }
}

