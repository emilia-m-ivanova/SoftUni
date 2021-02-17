package PizzaCalories;

public enum BakingModifier {
    CRISPY(0.9),
    CHEWY(1.1),
    HOMEMADE(1.0);

    private double value;
    BakingModifier(double value) {
        this.value = value;
    }
    public double getValue() {
        return value;
    }
}
