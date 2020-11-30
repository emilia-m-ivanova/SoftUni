import java.util.Scanner;

public class EasterGuests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int guests = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double briocheNum = Math.ceil(guests*1.0/3);
        int eggsNum =guests*2 ;
        double priceFinal = briocheNum*4+eggsNum*0.45;
        double diff = Math.abs(priceFinal-budget);
        if(priceFinal<=budget){
            System.out.printf("Lyubo bought %.0f Easter bread and %d eggs. %nHe has %.2f lv. left.",briocheNum,eggsNum,diff);

        } else{
            System.out.printf("Lyubo doesn't have enough money.%nHe needs %.2f lv. more.",diff);
        }
    }
}
