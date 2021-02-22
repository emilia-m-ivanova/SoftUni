package vehicles;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", createVehicle(scanner.nextLine().split("\\s+")));
        vehicles.put("Truck", createVehicle(scanner.nextLine().split("\\s+")));

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            double value = Double.parseDouble(command[2]);
            if (command[0].equals("Drive")) {
                System.out.println(vehicles.get(command[1]).drive(value));
            } else {
                vehicles.get(command[1]).refuel(value);
            }
        }
        vehicles.forEach((k, v) -> System.out.printf("%s: %.2f%n", k, v.getFuelQuantity()));
    }

    public static Vehicle createVehicle(String[] tokens) {
        Vehicle vehicle = null;
        switch (tokens[0]) {
            case "Car":
                vehicle = new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
                break;
            case "Truck":
                vehicle = new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
                break;
        }
        return vehicle;
    }
}
