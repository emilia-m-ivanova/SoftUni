package PizzaCalories;

public enum ToppingsModifier {
    MEAT(1.2),
    VEGGIES(0.8),
    CHEESE(1.1),
    SAUCE(0.9);
    private double value;

    ToppingsModifier(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
