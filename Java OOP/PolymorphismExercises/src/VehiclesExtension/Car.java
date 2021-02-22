package VehiclesExtension;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double consumptionLperKm,double tankCapacity) {
        super(fuelQuantity, consumptionLperKm + 0.9,tankCapacity);
    }
}
