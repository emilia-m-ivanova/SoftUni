import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double coin;
        double moneyTotal = 0;
        while (!input.equals("Start")) {
            coin = Double.parseDouble(input);
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2) {
                moneyTotal += coin;
            }else{
                System.out.printf("Cannot accept %.2f%n",coin);
            }
            input = scanner.nextLine();
        }
        String product = scanner.nextLine();
        double pricePerProduct = 0;
        while (!product.equals("End")){
            switch (product){
                case "Nuts":
                    pricePerProduct=2;
                    break;
                case "Water":
                    pricePerProduct=0.7;
                    break;
                case "Crisps":
                    pricePerProduct=1.5;
                    break;
                case "Soda":
                    pricePerProduct=0.8;
                    break;
                case "Coke":
                    pricePerProduct=1.0;
                    break;
            }
            if (pricePerProduct>moneyTotal){
                System.out.println("Sorry, not enough money");
                System.out.println();
                product= scanner.nextLine();
                continue;
            }else{
                moneyTotal-=pricePerProduct;
            }
            if (pricePerProduct==0){
                System.out.println("Invalid product");
            }else {
                System.out.printf("Purchased %s%n",product);
            }
            pricePerProduct=0;
            product= scanner.nextLine();

        }
        System.out.printf("Change: %.2f",moneyTotal);
    }
}
