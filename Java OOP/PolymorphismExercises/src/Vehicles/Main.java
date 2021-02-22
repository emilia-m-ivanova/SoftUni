package Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carAsString = scanner.nextLine().split("\\s+");
        String[] truckAsString = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carAsString[1]),Double.parseDouble(carAsString[2]));
        Truck truck = new Truck(Double.parseDouble(truckAsString[1]),Double.parseDouble(truckAsString[2]));

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            double value = Double.parseDouble(command[2]);
            if(command[0].equals("Drive")){
                if(command[1].equals("Car")){
                    System.out.println(car.drive(value));
                }else{
                    System.out.println(truck.drive(value));
                }
            }else{
                if(command[1].equals("Car")){
                    car.refuel(value);
                }else{
                    truck.refuel(value);
                }
            }
        }
        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
    }
}
