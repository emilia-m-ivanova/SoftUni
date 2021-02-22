package vehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double consumptionLperKm;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double consumptionLperKm,double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.consumptionLperKm = consumptionLperKm;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getConsumptionLperKm() {
        return consumptionLperKm;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
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
        if(liters<=0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if(this.fuelQuantity + liters > this.tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += liters;
    }
}
