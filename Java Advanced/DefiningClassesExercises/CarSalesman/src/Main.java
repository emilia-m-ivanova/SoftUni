import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Engine> engines = new LinkedHashSet<>();
        readEngines(scanner, engines);
        Set<Car> cars = new LinkedHashSet<>();
        readCars(scanner, engines, cars);
        cars.forEach(System.out::println);
    }

    private static void readEngines(Scanner scanner, Set<Engine> engines) {
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Engine engine;
            String model = tokens[0];
            String power = tokens[1];
            String displacement;
            String efficiency;
            if(tokens.length==4){
                displacement = tokens[2];
                efficiency = tokens[3];
                engine = new Engine(model,power,displacement,efficiency);
            }else if(tokens.length==2){
                engine = new Engine(model,power);
            }else{
                engine = new Engine(model,power);
                if(Character.isDigit(tokens[2].charAt(0))){
                    displacement = tokens[2];
                    engine.setDisplacement(displacement);
                }else{
                    efficiency = tokens[2];
                    engine.setEfficiency(efficiency);
                }
            }
            engines.add(engine);
        }
    }

    private static void readCars(Scanner scanner, Set<Engine> engines, Set<Car> cars) {
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Car car;
            String model = tokens[0];
            Engine engine = engines.stream()
                    .filter(e->e.getModel().equals(tokens[1]))
                    .findAny()
                    .get();
            String weight;
            String color;
            if(tokens.length==4){
                weight = tokens[2];
                color = tokens[3];
                car = new Car(model,engine,weight,color);
            }else if(tokens.length==2){
                car = new Car(model,engine);
            }else{
                car = new Car(model,engine);
                if(Character.isDigit(tokens[2].charAt(0))){
                    weight = tokens[2];
                    car.setWeight(weight);
                }else{
                    color = tokens[2];
                    car.setColor(color);
                }
            }
            cars.add(car);
        }
    }
}
