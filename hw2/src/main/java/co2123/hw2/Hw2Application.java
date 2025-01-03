package co2123.hw2;

import co2123.hw2.model.Bakery;
import co2123.hw2.model.Bread;
import co2123.hw2.model.Ingredient;
import co2123.hw2.repo.BakeryRepository;
import co2123.hw2.repo.BreadRepository;
import co2123.hw2.repo.IngredientRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
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

    @Override
    public void run(String... args) throws Exception {
        Bakery bakery1 = new Bakery();
        bakery1.setID(1);
        bakery1.setAddress("Bakery 1");
        bakery1 = bakeryRepository.save(bakery1);

        Bakery bakery2 = new Bakery();
        bakery2.setID(2);
        bakery2.setAddress("Bakery 2");
        bakery2 = bakeryRepository.save(bakery2);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setIdentifier(1);
        ingredient1.setAmount(69);
        ingredient1 = ingredientRepository.save(ingredient1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setIdentifier(2);
        ingredient2.setAmount(20);
        ingredient2 = ingredientRepository.save(ingredient2);

        Bread bread1 = new Bread();
        bread1.setIngredients(new ArrayList<>());
        bread1.getIngredients().add(ingredient1);
        bread1.setBakeries(new ArrayList<>());
        bread1.getBakeries().add(bakery1);
        bread1.setName("Sourdough");
        bread1.setFilling(ingredient1);
        bread1 = breadRepository.save(bread1);

        Bread bread2 = new Bread();
        bread2.setIngredients(new ArrayList<>());
        bread2.getIngredients().add(ingredient2);
        bread2.setBakeries(new ArrayList<>());
        bread2.getBakeries().add(bakery2);
        bread2.setName("Baguette");
        bread2.setFilling(ingredient2);
        bread2 = breadRepository.save(bread2);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setIdentifier(3);
        ingredient3.setAmount(26);
        ingredient3 = ingredientRepository.save(ingredient3);

        Bread bread3 = new Bread();
        bread3.setIngredients(new ArrayList<>());
        bread3.getIngredients().add(ingredient3);
        bread3.setBakeries(new ArrayList<>());
        bread3.getBakeries().add(bakery1);
        bread3.setName("Ciabatta");
        bread3.setFilling(ingredient3);
        bread3 = breadRepository.save(bread3);

        bakery1.setNewest(bread1);
        bakery2.setNewest(bread2);
        bakery1.setBreads(new ArrayList<>());
        bakery1.getBreads().add(bread1);
        bakery1.getBreads().add(bread3);
        bakery2.setBreads(new ArrayList<>());
        bakery2.getBreads().add(bread2);
        bakery1 = bakeryRepository.save(bakery1);
        bakery2 = bakeryRepository.save(bakery2);
    }
    public static void main(String[] args) {
        SpringApplication.run(Hw2Application.class, args);
    }
}
