package bakery.repositories;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.repositories.interfaces.FoodRepository;

import java.util.Collection;

public class FoodRepositoryImpl extends RepositoryImpl implements FoodRepository {
    @Override
    public BakedFood getByName(String name) {
        Collection<BakedFood> food = super.getAll();
        BakedFood result = null;
        for (BakedFood e : food) {
            if(e.getName().equals(name)){
                result = e;
                break;
            }
        }
        return result;
    }
}
