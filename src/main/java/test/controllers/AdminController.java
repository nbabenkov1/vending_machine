package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.models.Drink;
import test.service.DrinkService;

/**
 * Created by N.Babenkov on 25.06.2018.
 **/
@Controller
public class AdminController {
    private final DrinkService drinkService;

    @Autowired
    public AdminController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @RequestMapping(value = "/drink/{name}/{cost}/{containsAlcohol}", method = RequestMethod.POST)
    public String saveDrink(@PathVariable Drink drink){
        drinkService.addDrink(drink.getName(), drink.getCost(), drink.isContainsAlcohol());
        return "index";
    }

//    @RequestMapping(value = "/drink/{name}", method = RequestMethod.GET)
    @GetMapping("/drink/{name}")
    public String searchByName(@PathVariable("name") String name, Model model){
        Drink drink = drinkService.getDrinkByName(name);
        model.addAttribute("cost", drink.getCost());
        return "index";
    }

    @GetMapping("/")
    public String zhopa(){
        return "index";
    }
}
