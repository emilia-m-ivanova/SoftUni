public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCost1km;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCost1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost1km = fuelCost1km;
        this.distanceTraveled = 0;
    }

    public void changeDistance(int distanceTraveled) {
        if (checkIfFuelIsEnough(distanceTraveled)) {
            this.distanceTraveled += distanceTraveled;
            this.fuelAmount -= distanceTraveled * this.fuelCost1km;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public boolean checkIfFuelIsEnough(int distanceTraveled) {
        return distanceTraveled * this.fuelCost1km <= this.fuelAmount;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",this.model,this.fuelAmount,this.distanceTraveled);
    }
}
