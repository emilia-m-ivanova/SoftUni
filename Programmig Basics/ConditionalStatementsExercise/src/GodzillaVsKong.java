import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int actor = Integer.parseInt(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());
        double decor = budget * 10 * 0.01;
        if (actor >= 150) {
            price = price * 90 * 0.01;
        }
        double priceAll = (price * actor) + decor;
        double diff = Math.abs(budget - priceAll);
        if (priceAll > budget) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", diff);
        } else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", diff);
        }
    }
}
