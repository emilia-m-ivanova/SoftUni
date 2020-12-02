import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {
    static class Vehicle{
        String typeOfVehicle;
        String model;
        String color;
        int horsepower;
        public Vehicle(String typeOfVehicle,String model,String color, int horsepower){
            this.typeOfVehicle=typeOfVehicle;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }
        public String getModel(){
            return this.model;
        }
        public int getHorsepower(){
            return this.horsepower;
        }
        public String getTypeOfVehicle(){
            return this.typeOfVehicle;
        }

        @Override
        public String toString() {
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d",
                    typeOfVehicle.substring(0,1).toUpperCase()+typeOfVehicle.substring(1), model,color,horsepower);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List <Vehicle> vehicleList = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String [] detailsArray = input.split(" ");
            Vehicle vehicle = new Vehicle(detailsArray[0],detailsArray[1],detailsArray[2],
                    Integer.parseInt(detailsArray[3]));
            vehicleList.add(vehicle);
            input = scanner.nextLine();
        }
        String model = scanner.nextLine();
        while(!model.equals("Close the Catalogue")){
            for (Vehicle vehicle : vehicleList) {
                if(vehicle.getModel().equals(model)){
                    System.out.println(vehicle.toString());
                }
            }
            model = scanner.nextLine();
        }
        double horsePowerCar = 0;
        double horsePowerTruck = 0;
        int countCars = 0;
        int countTrucks = 0;
        for (Vehicle vehicle : vehicleList) {
            if(vehicle.getTypeOfVehicle().equals("car")){
                horsePowerCar+= vehicle.getHorsepower();
                countCars++;
            }else{
                horsePowerTruck+= vehicle.getHorsepower();
                countTrucks++;
            }
        }

        if(countCars==0){
            countCars=1;
        }
        if(countTrucks==0){
            countTrucks=1;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n",horsePowerCar/countCars);
        System.out.printf("Trucks have average horsepower of: %.2f.",horsePowerTruck/countTrucks);
    }
}
