package co2123.hw2.repo;
import org.springframework.data.repository.CrudRepository;
import co2123.hw2.model.Bakery;
import java.util.List;

public interface BakeryRepository extends CrudRepository<Bakery, Integer> {

    List<Bakery> findByAddress(String address);
    List<Bakery> findByNewest(Bakery bakery);

}
