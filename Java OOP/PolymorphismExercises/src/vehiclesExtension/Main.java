package vehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", createVehicle(scanner.nextLine().split("\\s+")));
        vehicles.put("Truck", createVehicle(scanner.nextLine().split("\\s+")));
        vehicles.put("Bus", createVehicle(scanner.nextLine().split("\\s+")));
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            double value = Double.parseDouble(command[2]);
            if (command[0].equals("Drive")) {
                System.out.println(vehicles.get(command[1]).drive(value));
            } else if (command[0].equals("Refuel")){
                try {
                    vehicles.get(command[1]).refuel(value);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                Bus bus = (Bus) vehicles.get("Bus");
                System.out.println(bus.driveEmpty(value));
            }
        }
        vehicles.forEach((k, v) -> System.out.printf("%s: %.2f%n", k, v.getFuelQuantity()));


    }

    public static Vehicle createVehicle(String[] tokens) {
        Vehicle vehicle = null;
        switch (tokens[0]) {
            case "Car":
                vehicle = new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
                break;
            case "Truck":
                vehicle = new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
                break;
            case "Bus":
                vehicle = new Bus(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
                break;
        }
        return vehicle;
    }
}
