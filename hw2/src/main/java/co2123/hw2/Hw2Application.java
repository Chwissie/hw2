package co2123.hw2;

import co2123.hw2.model.Bakery;
import co2123.hw2.model.Bread;
import co2123.hw2.model.Ingredient;
import co2123.hw2.repo.BakeryRepository;
import co2123.hw2.repo.BreadRepository;
import co2123.hw2.repo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Hw2Application implements CommandLineRunner {
    @Autowired
    private BakeryRepository bakeryRepository;

    @Autowired
    private BreadRepository breadRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    public static List<Bakery> bakeryList = new ArrayList<>();
    public static List<Bread> breadList = new ArrayList<>();
    public static List<Ingredient> ingredientList = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {
        Bakery bakery = new Bakery();
        Bread bread = new Bread();
        Ingredient ingredient = new Ingredient();


        bakeryList.add(bakery);
        breadList.add(bread);
        ingredientList.add(ingredient);


        bakery.setAddress("here");
        bakery.setID(1);
        bakery.setNewest(bread);
        bakery.setBreads(breadList);

        bread.setName("Bread");
        bread.setFilling(ingredient);
        bread.setBakeries(bakeryList);
        bread.setIngredients(ingredientList);

        ingredient.setAmount(5);
        ingredient.setIdentifier(1);

        breadRepository.save(bread);
        ingredientRepository.save(ingredient);
        bakeryRepository.save(bakery);
    }
    public static void main(String[] args) {
        SpringApplication.run(Hw2Application.class, args);
    }
}
