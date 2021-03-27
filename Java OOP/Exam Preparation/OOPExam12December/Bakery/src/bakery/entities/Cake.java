package bakery.entities;

public class Cake extends BaseFood {
    private static double InitialCakePortion = 245;

    public Cake(String name, double price) {
        super(name, InitialCakePortion, price);
    }

}
