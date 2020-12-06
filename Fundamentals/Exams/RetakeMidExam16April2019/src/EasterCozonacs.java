import java.util.Scanner;

public class EasterCozonacs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        double flourPrice = Double.parseDouble(scanner.nextLine());
        double eggsPack = flourPrice*0.75;
        double milkPrice = flourPrice*1.25;
        double priceCozonac = flourPrice+eggsPack+milkPrice*0.25;
        int cozonacs = 0;
        int eggs = 0;
        while (budget-priceCozonac>0){
            budget-=priceCozonac;
            cozonacs++;
            eggs+=3;
            if(cozonacs%3==0){
                eggs-=cozonacs-2;
            }
        }
        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.",cozonacs,eggs,budget);

    }
}
