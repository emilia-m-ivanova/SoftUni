package bakery.entities;

public class Bread extends BaseFood {
    private static double InitialBreadPortion = 200;

    public Bread(String name, double price) {
        super(name, InitialBreadPortion, price);
    }
}
