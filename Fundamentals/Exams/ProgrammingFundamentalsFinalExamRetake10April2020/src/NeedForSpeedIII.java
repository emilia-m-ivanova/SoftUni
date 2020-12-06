import java.util.*;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map <String, List<Integer>> cars = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String [] input = scanner.nextLine().split("\\|");
            String car = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);
            cars.put(car,new ArrayList<>(){{add(mileage);add(fuel);}});
        }
        String command = scanner.nextLine();
        while(!command.equals("Stop")){
            String [] tokens = command.split(" : ");
            String car = tokens[1];
            switch (tokens[0]){
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);
                    driveCar(car,distance,fuel,cars);
                    break;
                case "Refuel":
                    fuel = Integer.parseInt(tokens[2]);
                    refuelCar(car,fuel,cars);
                    break;
                case "Revert":
                    int km = Integer.parseInt(tokens[2]);
                    revertMileage(car,km,cars);
                    break;
            }

            command = scanner.nextLine();
        }

        cars.entrySet()
                .stream()
                .sorted((a,b)->b.getValue().get(0).compareTo(a.getValue().get(0)))
                .forEach(c-> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                        c.getKey(),c.getValue().get(0),c.getValue().get(1)));
    }

    private static void revertMileage(String car, int km, Map<String, List<Integer>> cars) {
        int updatedMileage = Math.max(cars.get(car).get(0)-km,10000);
        if(updatedMileage>10000){
            System.out.printf("%s mileage decreased by %d kilometers%n",car,cars.get(car).get(0)-updatedMileage);
        }
        cars.get(car).set(0,updatedMileage);
    }

    private static void refuelCar(String car, int fuel, Map<String, List<Integer>> cars) {
        int updatedFuel = Math.min(cars.get(car).get(1)+fuel,75);
        System.out.printf("%s refueled with %d liters%n",car,updatedFuel-cars.get(car).get(1));
        cars.get(car).set(1,updatedFuel);
    }

    private static void driveCar(String car, int distance, int fuel, Map<String, List<Integer>> cars) {
        int updatedFuel = cars.get(car).get(1)-fuel;
        int updatedMileage = cars.get(car).get(0)+distance;
        if(updatedFuel<0){
            System.out.println("Not enough fuel to make that ride");
        }else{
            cars.get(car).set(1,updatedFuel);
            System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",car,distance,fuel);
            if(updatedMileage<100000){
                cars.get(car).set(0,updatedMileage);
            }else{
                System.out.println("Time to sell the "+car+"!");
                cars.remove(car);
            }
        }
    }
}
