package bakery.repositories;

import bakery.entities.drinks.interfaces.Drink;
import bakery.repositories.interfaces.DrinkRepository;
import java.util.Collection;

public class DrinkRepositoryImpl extends RepositoryImpl implements DrinkRepository {
    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        Collection<Drink> drinks = super.getAll();
        Drink result = null;
        for (Drink drink : drinks) {
            if(drink.getName().equals(drinkName) && drink.getBrand().equals(drinkBrand)){
                result = drink;
                break;
            }
        }
        return result;
    }
}
