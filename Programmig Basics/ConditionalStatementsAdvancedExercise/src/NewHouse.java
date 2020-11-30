import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double priceTotal = 0;
        switch (type) {
            case "Roses":
                if (count > 80) {
                    priceTotal = (count * 5) * 90 * 0.01;
                } else {
                    priceTotal = count * 5;
                }
                break;
            case "Dahlias":
                if (count > 90) {
                    priceTotal = (count * 3.8) * 85 * 0.01;
                } else {
                    priceTotal = count * 3.8;
                }
                break;
            case "Tulips":
                if (count > 80) {
                    priceTotal = (count * 2.8) * 85 * 0.01;
                } else {
                    priceTotal = count * 2.8;
                }
                break;
            case "Narcissus":
                if (count < 120) {
                    priceTotal = (count * 3) * 115 * 0.01;
                } else {
                    priceTotal = count * 3;
                }
                break;
            case "Gladiolus":
                if (count < 80) {
                    priceTotal = (count * 2.5) * 120 * 0.01;
                } else {
                    priceTotal = count * 2.5;
                }
                break;
        }
        double difference = Math.abs(budget - priceTotal);
        if (priceTotal <= budget) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", count, type, difference);
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", difference);
        }
    }
}

