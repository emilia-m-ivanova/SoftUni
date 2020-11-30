import java.util.Scanner;

public class EasterShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int eggsTotal = Integer.parseInt(scanner.nextLine());
        String stock = scanner.nextLine();
        int eggsSold = 0;
        while (!stock.equals("Close")){
            int eggsNum = Integer.parseInt(scanner.nextLine());
            switch (stock){
                case "Buy":
                    if(eggsTotal<eggsNum){
                        System.out.printf("Not enough eggs in store!%nYou can buy only %d.",eggsTotal);
                        return;
                    }
                    eggsTotal-=eggsNum;
                    eggsSold+=eggsNum;
                    break;
                case "Fill":
                    eggsTotal+=eggsNum;
            }

            stock = scanner.nextLine();
        }
        System.out.printf("Store is closed!%n%d eggs sold.",eggsSold);
    }
}
