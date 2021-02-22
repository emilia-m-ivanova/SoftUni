package wildFarm;

import java.text.DecimalFormat;

public class Cat extends Feline {
    private String breed;

    protected Cat(String animalType,String animalName, double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName,animalWeight, livingRegion);
        this.setBreed(breed);
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    protected void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    protected void eat(Food food) {
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###.##");
        return String.format
                ("Cat[%s, %s, %s, %s, %d]",this.getAnimalName(),this.breed,df.format(this.getAnimalWeight()),this.getLivingRegion(),this.getFoodEaten());
    }
}
