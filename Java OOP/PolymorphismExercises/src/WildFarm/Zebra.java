package WildFarm;

public class Zebra extends Mammal {
    protected Zebra(String animalType, String animalName, double animalWeight,String region) {
        super(animalType, animalName, animalWeight,region);
    }

    @Override
    protected void makeSound() {
        System.out.println("Zs");
    }

    @Override
    protected void eat(Food food) {
        if (food instanceof Meat) {
            throw new IllegalArgumentException(this.getClass().getSimpleName() + "s are not eating that type of food!");
        }

        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }
}
