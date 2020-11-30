import java.util.Scanner;

public class EasterParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int guests = Integer.parseInt(scanner.nextLine());
        double pricePerPerson = Double.parseDouble(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        double cakePrice = budget*10*0.01;
        if(guests>20){
            pricePerPerson-=pricePerPerson*25*0.01;
        }else if(guests>15){
            pricePerPerson-=pricePerPerson*20*0.01;
        }else if(guests>=10){
            pricePerPerson-=pricePerPerson*15*0.01;
        }
        double priceTotal = cakePrice+pricePerPerson*guests;
        double diff = Math.abs(budget-priceTotal);
        if(priceTotal<=budget) {
            System.out.printf("It is party time! %.2f leva left.",diff);
        }else{
            System.out.printf("No party! %.2f leva needed.",diff);
        }
    }
}