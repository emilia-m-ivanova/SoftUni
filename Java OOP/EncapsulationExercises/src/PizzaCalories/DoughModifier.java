package PizzaCalories;

public enum DoughModifier {
    WHITE(1.5),
    WHOLEGRAIN(1.0);

    private double value;
    DoughModifier(double value) {
        this.value = value;
    }
    public double getValue() {
        return value;
    }
}
