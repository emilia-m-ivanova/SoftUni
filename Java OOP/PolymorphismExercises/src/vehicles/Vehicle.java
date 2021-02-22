package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuelQuantity;
    private double consumptionLperKm;

    protected Vehicle(double fuelQuantity, double consumptionLperKm) {
        this.fuelQuantity = fuelQuantity;
        this.consumptionLperKm = consumptionLperKm;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public String drive(double km) {
        if (this.fuelQuantity < this.consumptionLperKm * km) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }
        DecimalFormat df = new DecimalFormat("###.##");
        this.fuelQuantity -= this.consumptionLperKm * km;
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(km));
    }



    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }
}
