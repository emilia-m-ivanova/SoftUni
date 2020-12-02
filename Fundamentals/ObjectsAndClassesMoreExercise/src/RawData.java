import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RawData {
    static class Car {
        String model;
        Engine engine;
        Cargo cargo;
        List<Tyre> tyres;

        public Car(String model, Engine engine, Cargo cargo, List<Tyre> tyres) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tyres = tyres;
        }

        public String getModel() {
            return this.model;
        }

        public Engine getEngine() {
            return this.engine;
        }

        public Cargo getCargo() {
            return this.cargo;
        }

        public List<Tyre> getTyres() {
            return this.tyres;
        }

    }

    static class Engine {
        int speed;
        int power;

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }

        public int getPower() {
            return this.power;
        }
    }

    static class Cargo {
        int weight;
        String type;

        public Cargo(int weight, String type) {
            this.weight = weight;
            this.type = type;
        }

        public String getType() {
            return this.type;
        }

    }

    static class Tyre {
        double pressure;
        int age;

        public Tyre(double pressure, int age) {
            this.pressure = pressure;
            this.age = age;
        }

        public double getPressure() {
            return this.pressure;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            Engine engine = new Engine(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            Cargo cargo = new Cargo(Integer.parseInt(input[3]), input[4]);
            List<Tyre> tyres = new ArrayList<>();
            for (int j = 0; j < 8; j += 2) {
                Tyre tyre = new Tyre(Double.parseDouble(input[5 + j]), Integer.parseInt(input[6 + j]));
                tyres.add(tyre);
            }
            Car car = new Car(input[0], engine, cargo, tyres);
            cars.add(car);
        }
        String input = scanner.nextLine();
        for (Car car : cars) {
            switch (input) {
                case "fragile":
                    if (car.getCargo().getType().equals("fragile")) {
                        for (Tyre tyre : car.getTyres()) {
                            if (tyre.getPressure() < 1) {
                                System.out.println(car.getModel());
                                break;
                            }
                        }
                    }
                    break;
                case "flamable":
                    if (car.getCargo().getType().equals("flamable")
                            && car.getEngine().getPower() > 250) {
                        System.out.println(car.getModel());
                    }
                    break;
            }

        }
    }
}