package restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage{

    public Coffee(String name, double caffeine) {
        super(name, COFFEE_PRICE, COFFEE_MILLILITERS);
        this.caffeine = caffeine;
    }

    private final static double COFFEE_MILLILITERS = 50;
    private final static BigDecimal COFFEE_PRICE = new BigDecimal(3.50);
    private double caffeine;

    public double getCaffeine() {
        return caffeine;
    }
}
