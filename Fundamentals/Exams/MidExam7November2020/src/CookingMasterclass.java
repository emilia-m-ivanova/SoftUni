import java.util.Scanner;

public class CookingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceFlour = Double.parseDouble(scanner.nextLine());
        double priceEgg = Double.parseDouble(scanner.nextLine());
        double priceApron = Double.parseDouble(scanner.nextLine());
        double finalPrice = 0;
        for (int i = 1; i <= students; i++) {
            if (i % 5 == 0) {
                finalPrice += priceEgg * 10 + priceApron;
            } else {
                finalPrice += priceFlour + priceEgg * 10 + priceApron;
            }
        }
        double additionalApron = Math.ceil((double) students * 0.2);
        finalPrice += additionalApron * priceApron;
        double difference = Math.abs(budget - finalPrice);
        if (budget >= finalPrice) {
            System.out.printf("Items purchased for %.2f$.", finalPrice);
        } else {
            System.out.printf("%.2f$ more needed.", difference);
        }
    }
}
