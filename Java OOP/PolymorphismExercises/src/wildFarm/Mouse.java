package wildFarm;

public class Mouse extends Mammal{
    protected Mouse(String animalType, String animalName, double animalWeight,String region) {
        super(animalType, animalName, animalWeight,region);
    }

    @Override
    protected void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    protected void eat(Food food) {
        if(food instanceof Meat){
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }

        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }
}
