package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {

    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add (Car car){
        if(this.data.size()<capacity){
            this.data.add(car);
        }
    }

    public boolean remove (String manufacturer, String model){
        for (Car car : this.data) {
            if(car.getManufacturer().equals(manufacturer) &&
            car.getModel().equals(model)){
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar(){
        return this.data.stream()
                .max(Comparator.naturalOrder())
                .orElse(null);
    }

    public Car getCar (String manufacturer, String model){
        return this.data.stream()
                .filter(c->c.getManufacturer().equals(manufacturer)&&c.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are parked in ").append(this.type).append(":").append(System.lineSeparator());
        for (Car car : this.data) {
            sb.append(car).append(System.lineSeparator());
        }

        return String.valueOf(sb);
    }

}
