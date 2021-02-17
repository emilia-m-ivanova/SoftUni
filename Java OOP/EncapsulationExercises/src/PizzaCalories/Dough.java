package PizzaCalories;

import java.util.Arrays;

public class Dough {


    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (Arrays.stream(DoughModifier.values())
                .noneMatch(e -> e.toString().equals(flourType.toUpperCase()))) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (Arrays.stream(BakingModifier.values())
                .noneMatch(e -> e.toString().equals(bakingTechnique.toUpperCase()))) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (1 > weight || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return this.weight * 2 *
                (DoughModifier.valueOf(flourType.toUpperCase()).getValue()) *
                (BakingModifier.valueOf(bakingTechnique.toUpperCase()).getValue());
    }

}
