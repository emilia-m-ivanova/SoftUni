package vehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle{
    protected Bus(double fuelQuantity, double consumptionLperKm, double tankCapacity) {
        super(fuelQuantity, consumptionLperKm, tankCapacity);
    }

    @Override
    public String drive(double km) {
        if (this.getFuelQuantity() < (this.getConsumptionLperKm() + 1.4) * km) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }
        DecimalFormat df = new DecimalFormat("###.##");
        this.setFuelQuantity(this.getFuelQuantity() - (this.getConsumptionLperKm() + 1.4) * km);
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(km));
    }

    public String driveEmpty(double km) {
        return super.drive(km);
    }
}
