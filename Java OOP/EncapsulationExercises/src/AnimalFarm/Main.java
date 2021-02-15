package AnimalFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Chicken chicken = new Chicken(scanner.nextLine(),Integer.parseInt(scanner.nextLine()));
            System.out.println(chicken.toString());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
