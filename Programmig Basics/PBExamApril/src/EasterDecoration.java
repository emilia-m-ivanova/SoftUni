import java.util.Scanner;

public class EasterDecoration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int clients = Integer.parseInt(scanner.nextLine());
        double priceTotal = 0;
        for (int i = 1; i <= clients; i++) {
            String article = scanner.nextLine();
            int productsNum = 0;
            double price = 0;
            while (!article.equals("Finish")) {
                productsNum++;
                switch (article) {
                    case "basket":
                        price += 1.5;
                        break;
                    case "wreath":
                        price += 3.8;
                        break;
                    case "chocolate bunny":
                        price += 7;
                        break;
                }
                article = scanner.nextLine();
            }
            if (productsNum % 2 == 0) {
                price -= price * 20 * 0.01;
            }
            priceTotal += price;
            System.out.printf("You purchased %d items for %.2f leva.%n", productsNum, price);

        }
        System.out.printf("Average bill per client is: %.2f leva.", priceTotal / clients);
    }
}
