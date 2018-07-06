package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.models.Drink;
import test.repositories.DrinkRepository;

/**
 * Created by N.Babenkov on 25.06.2018.
 **/
@Service
public class DrinkService {
    private DrinkRepository drinkRepo;

    @Autowired
    public DrinkService(DrinkRepository drinkRepo) {
        this.drinkRepo = drinkRepo;
    }

    public void addDrink(String drinkName, int cost, boolean containsAlcohol) {
        Drink drink = new Drink();
        drink.setName(drinkName);
        drink.setCost(cost);
        drink.setContainsAlcohol(containsAlcohol);
        drinkRepo.save(drink);
        System.out.println(drinkRepo.findAll());
    }

    public Drink getDrinkByName(String name) {
        return drinkRepo.findDrinkByName(name);
    }
}
