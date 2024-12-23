package co2123.hw2;

import co2123.hw2.repo.BakeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hw2Application {

    @Autowired
    private BakeryRepository bakeryRepository;

    public static void main(String[] args) {
        SpringApplication.run(Hw2Application.class, args);
    }
}
