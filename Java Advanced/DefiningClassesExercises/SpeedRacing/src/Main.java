import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCost1km = Double.parseDouble(input[2]);
            Car car = new Car(model, fuelAmount, fuelCost1km);
            cars.put(model, car);
        }
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String carModel = tokens[1];
            int km = Integer.parseInt(tokens[2]);
            cars.get(carModel).changeDistance(km);
            input = scanner.nextLine();
        }
        cars.values()
                .forEach(c -> System.out.println(c.toString()));
    }
}
