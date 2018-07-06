package test.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import test.models.Drink;

import java.util.List;

/**
 * Created by N.Babenkov on 25.06.2018.
 **/
@Repository
public interface DrinkRepository extends CrudRepository<Drink,Integer> {
    Drink findDrinkByName(String name);
}
