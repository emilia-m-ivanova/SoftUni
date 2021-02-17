package PizzaCalories;

import java.util.Arrays;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!typeIsValid(toppingType)) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (1 > weight || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    private boolean typeIsValid(String type) {
        return Arrays.stream(ToppingsModifier.values())
                .anyMatch(e -> e.toString().equals(type.toUpperCase()));
    }

    public double calculateCalories() {
        return this.weight * 2 * (ToppingsModifier.valueOf(toppingType.toUpperCase()).getValue());
    }
}
