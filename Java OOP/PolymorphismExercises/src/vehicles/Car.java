package vehicles;

public class Car extends Vehicle{
    public Car(double fuelQuantity, double consumptionLperKm) {
        super(fuelQuantity, consumptionLperKm + 0.9);
    }
}
