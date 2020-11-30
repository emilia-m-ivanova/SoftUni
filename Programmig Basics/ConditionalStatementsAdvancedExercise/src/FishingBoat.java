import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishmen = Integer.parseInt(scanner.nextLine());
        double rent = 0;
        switch (season) {
            case "Spring":
                rent = 3000;
                break;
            case "Summer":
            case "Autumn":
                rent = 4200;
                break;
            case "Winter":
                rent = 2600;
                break;
        }
        if (fishmen <= 6) {
            rent = rent*90*0.01;
        } else if(fishmen<=11){
            rent = rent*85*0.01;
        } else{
            rent = rent*75*0.01;
        }
        if(fishmen%2==0 && !season.equals("Autumn")){
            rent = rent*95*0.01;
        }
        double difference = Math.abs(budget-rent);
        if(budget>=rent){
            System.out.printf("Yes! You have %.2f leva left.",difference);
        } else{
            System.out.printf("Not enough money! You need %.2f leva.", difference);
        }
    }
}
