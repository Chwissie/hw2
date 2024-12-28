package co2123.hw2;

import co2123.hw2.model.Bakery;
import co2123.hw2.model.Bread;
import co2123.hw2.model.Ingredient;
import co2123.hw2.repo.BakeryRepository;
import co2123.hw2.repo.BreadRepository;
import co2123.hw2.repo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hw2Application {

    @Autowired
    private BakeryRepository bakeryRepository;
    private BreadRepository breadRepository;
    private IngredientRepository ingredientRepository;

    public static void main(String[] args) {
        SpringApplication.run(Hw2Application.class, args);
        Bakery bakery = new Bakery();
        Bread bread = new Bread();
        Ingredient ingredient = new Ingredient();
    }
}
