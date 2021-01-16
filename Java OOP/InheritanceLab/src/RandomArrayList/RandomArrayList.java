package RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    private Random random;

    public RandomArrayList(){
        this.random = new Random();
    }

    public T getRandomElement(){
        int randomIndex = this.random.nextInt(super.size());
        return this.remove(randomIndex);
    }
}
