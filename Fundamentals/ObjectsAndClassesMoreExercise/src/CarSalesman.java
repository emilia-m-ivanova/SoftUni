import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarSalesman {
    static class Car {
        String model;
        Engine engine;
        String weight = "n/a";
        String color = "n/a";

        public Car(String model, Engine engine) {
            this.model = model;
            this.engine = engine;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return this.model + ":" + System.lineSeparator()+
                    this.engine.getModel() + ":" + System.lineSeparator()+
                    "Power: " + this.engine.getPower() + System.lineSeparator()+
                    "Displacement: "+this.engine.getDisplacement() + System.lineSeparator()+
                    "Efficiency: " + this.engine.getEfficiency() + System.lineSeparator()+
                    "Weight: " + this.weight + System.lineSeparator()+
                    "Color: " + this.color;
        }
    }

    static class Engine {
        String model;
        String power;
        String displacement = "n/a";
        String efficiency = "n/a";

        public Engine(String model, String power) {
            this.model = model;
            this.power = power;
        }

        public String getModel() {
            return this.model;
        }

        public String getPower() {
            return this.power;
        }

        public String getDisplacement() {
            return this.displacement;
        }

        public String getEfficiency() {
            return this.efficiency;
        }

        public void setEfficiency(String efficiency) {
            this.efficiency = efficiency;
        }

        public void setDisplacement(String displacement) {
            this.displacement = displacement;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            Engine engine = new Engine(input[0], input[1]);
            if (input.length == 3) {
                char c = input[2].charAt(0);
                if (Character.isLetter(c)) {
                    engine.setEfficiency(input[2]);
                } else {
                    engine.setDisplacement(input[2]);
                }
            } else if (input.length == 4) {
                engine.setDisplacement(input[2]);
                engine.setEfficiency(input[3]);
            }
            engines.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {
            String[] input = scanner.nextLine().split(" ");
            Engine engine1 = null;
            for (Engine engine : engines) {
                if (engine.getModel().equals(input[1])) {
                    engine1 = engine;
                }
            }
            Car car = new Car(input[0], engine1);
            if (input.length == 3) {
                char c = input[2].charAt(0);
                if (Character.isLetter(c)) {
                    car.setColor(input[2]);
                } else {
                    car.setWeight(input[2]);
                }
            } else if (input.length == 4) {
                car.setWeight(input[2]);
                car.setColor(input[3]);
            }
            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car.toString());
        }


    }
}
