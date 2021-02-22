package Vehicles;

public class Truck extends Vehicle{
    public Truck(double fuelQuantity, double consumptionLperKm) {
        super(fuelQuantity, consumptionLperKm + 1.6);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters*0.95);
    }
}
