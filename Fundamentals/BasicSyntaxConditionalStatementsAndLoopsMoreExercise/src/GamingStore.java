import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double currentMoney = Double.parseDouble(scanner.nextLine());
        String game = scanner.nextLine();
        double moneySpent = 0;
        while(!game.equals("Game Time")){
            double currentPrice = 0;
            switch (game){
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    currentPrice=39.99;
                    break;
                case "CS: OG":
                    currentPrice=15.99;
                    break;
                case "Zplinter Zell":
                    currentPrice=19.99;
                    break;
                case "Honored 2":
                    currentPrice=59.99;
                    break;
                case "RoverWatch":
                    currentPrice=29.99;
                    break;
                default:currentPrice=0;
                break;
                }
            if(currentPrice==0){
                System.out.println("Not Found");
            }else if (currentMoney>=currentPrice){
                System.out.printf("Bought %s%n",game);
                currentMoney-=currentPrice;
                moneySpent+=currentPrice;
            }else{
                System.out.println("Too Expensive");
            }
            if(currentMoney==0){
                System.out.println("Out of money!");
                return;
            }

            game= scanner.nextLine();
        }
        System.out.printf("Total spent: $%.2f. Remaining: $%.2f",moneySpent,currentMoney);
    }
}
