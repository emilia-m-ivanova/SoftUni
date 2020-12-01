import java.util.Scanner;

public class TheHuntingGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int players = Integer.parseInt(scanner.nextLine());
        double energy = Double.parseDouble(scanner.nextLine());
        double waterPerDayPerPerson = Double.parseDouble(scanner.nextLine());
        double foodPerDayPerPerson = Double.parseDouble(scanner.nextLine());
        double water = players*days*waterPerDayPerPerson;
        double food = players*days*foodPerDayPerPerson;
        for (int i = 1; i <= days; i++) {
            energy-=Double.parseDouble(scanner.nextLine());
            if(energy<=0){
                System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.",food,water);
               return;
            }
            if(i%2==0){
                water*=0.7;
                energy*=1.05;
            }
            if(i%3==0){
                food-=food/players;
                energy*=1.1;
            }
        }
        System.out.printf("You are ready for the quest. You will be left with - %.2f energy!",energy);
    }
}
