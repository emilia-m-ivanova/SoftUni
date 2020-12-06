import java.util.Scanner;

public class DisneylandJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double price = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double moneySaved = 0;
        int currentMonth = 1;
        while (currentMonth<=months){
            if(currentMonth%2!=0){
                moneySaved-=moneySaved*0.16;
            }
            if(currentMonth%4==0){
                moneySaved+=moneySaved*0.25;
            }
            moneySaved+=price*0.25;
            currentMonth++;
        }
        double difference = Math.abs(price-moneySaved);
        if(moneySaved>=price){
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.",difference);
        }else{
            System.out.printf("Sorry. You need %.2flv. more.",difference);
        }
    }
}
