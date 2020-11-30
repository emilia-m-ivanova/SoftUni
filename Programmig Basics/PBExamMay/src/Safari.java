import java.util.Scanner;

public class Safari {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        double GasL = Double.parseDouble(scanner.nextLine());
        String day = scanner.nextLine();
        double price = GasL * 2.1 + 100;
        switch (day) {
            case "Saturday":
                price -= price * 10 * 0.01;
                break;
            case "Sunday":
                price -= price * 20 * 0.01;
        }
        double diff = Math.abs(budget - price);
        if (price<=budget) {
            System.out.printf("Safari time! Money left: %.2f lv. ", diff);
        } else {
            System.out.printf("Not enough money! Money needed: %.2f lv.", diff);
        }
    }
}
