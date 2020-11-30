import java.util.Scanner;

public class CleverLilly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        double priceMachine = Double.parseDouble(scanner.nextLine());
        int priceToy = Integer.parseInt(scanner.nextLine());
        int toys = 0;
        int moneyPerBD = 0;
        int sumMoney = 0;
        for (int i = 1; i <=age ; i++) {
            if(i%2==1){
                toys++;
            }
            else{
                moneyPerBD+=10;//10, 20, 30, 40, 50
                sumMoney+=moneyPerBD-1;
            }
        }
        int totalMoney = sumMoney+(toys*priceToy);
        double diff = Math.abs(totalMoney-priceMachine);
        if(priceMachine<=totalMoney){
            System.out.printf("Yes! %.2f",diff);
        }else{
            System.out.printf("No! %.2f",diff);
        }
    }
}
