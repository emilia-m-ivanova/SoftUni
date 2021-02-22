package vehiclesExtension;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double consumptionLperKm,double tankCapacity) {
        super(fuelQuantity, consumptionLperKm + 1.6,tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters*0.95);
    }
}
