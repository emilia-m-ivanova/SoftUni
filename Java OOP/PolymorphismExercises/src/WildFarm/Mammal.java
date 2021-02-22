package WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    private String livingRegion;

    protected Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###.##");
        return String.format("%s[%s, %s, %s, %d]",this.getAnimalType(),this.getAnimalName(),df.format(this.getAnimalWeight()),this.getLivingRegion(),this.getFoodEaten());
    }
}
