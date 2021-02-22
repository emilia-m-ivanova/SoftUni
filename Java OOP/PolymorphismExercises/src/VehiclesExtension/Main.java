package VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carAsString = scanner.nextLine().split("\\s+");
        String[] truckAsString = scanner.nextLine().split("\\s+");
        String[] busAsString = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carAsString[1]), Double.parseDouble(carAsString[2]), Double.parseDouble(carAsString[3]));
        Truck truck = new Truck(Double.parseDouble(truckAsString[1]), Double.parseDouble(truckAsString[2]), Double.parseDouble(truckAsString[3]));
        Bus bus = new Bus(Double.parseDouble(busAsString[1]), Double.parseDouble(busAsString[2]), Double.parseDouble(busAsString[3]));

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            double value = Double.parseDouble(command[2]);
            if (command[0].equals("Drive")) {

                if (command[1].equals("Car")) {
                    System.out.println(car.drive(value));
                } else if (command[1].equals("Truck")) {
                    System.out.println(truck.drive(value));
                } else {
                    System.out.println(bus.drive(value));
                }
            } else if (command[0].equals("Refuel")) {
                try {
                    if (command[1].equals("Car")) {
                        car.refuel(value);
                    } else if (command[1].equals("Truck")) {
                        truck.refuel(value);
                    } else {
                        bus.refuel(value);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println(bus.driveEmpty(value));
            }
        }
        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f%n", bus.getFuelQuantity());

    }
}
