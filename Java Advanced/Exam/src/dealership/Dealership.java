package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    private List<Car> data;
    private String name;
    private int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        return this.data.removeIf(p -> p.getManufacturer().equals(manufacturer) && p.getModel().equals(model));
    }

    public Car getCar(String manufacturer, String model){
        return this.data.stream()
                .filter(p -> p.getManufacturer().equals(manufacturer) && p.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public Car getLatestCar() {
        return this.data.stream()
                .max(Comparator.comparingInt(Car::getYear))
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are in a car dealership ").append(this.name).append(":").append(System.lineSeparator());
        for (Car car : this.data) {
            sb.append(car.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

}
