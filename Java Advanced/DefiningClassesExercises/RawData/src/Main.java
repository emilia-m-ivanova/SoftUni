import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<Car> cars = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String [] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            List<Tire> tires = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                double tirePressure = Double.parseDouble(tokens[5+2*j]);
                int tireAge = Integer.parseInt(tokens[5+2*j+1]);
                tires.add(new Tire(tireAge,tirePressure));
            }
            Car car = new Car(model,new Engine(engineSpeed,enginePower),new Cargo(cargoWeight,cargoType),tires);
            cars.add(car);
        }
        String cargoType = scanner.nextLine();
        Predicate<Car> checkCargo = e->e.getCargo().getType().equals(cargoType);
        if(cargoType.equals("fragile")){
            cars.stream()
                    .filter(checkCargo)
                    .filter(e->e.getTires()
                            .stream()
                            .anyMatch(t->t.getTirePressure()<1))
                    .forEach(e-> System.out.println(e.getModel()));
        }else{
            cars.stream()
                    .filter(checkCargo)
                    .filter(e->e.getEngine().getPower()>250)
                    .forEach(e-> System.out.println(e.getModel()));
        }
    }
}
