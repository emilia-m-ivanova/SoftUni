import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String destination = "";
        String accommodation = "";
        double money = 0;
        if (budget <= 100) {
            destination = "Bulgaria";
            switch (season) {
                case "summer":
                    accommodation = "Camp";
                    money = budget * 30 * 0.01;
                    break;
                case "winter":
                    accommodation = "Hotel";
                    money = budget * 70 * 0.01;
                    break;
            }
        } else if (budget <= 1000) {
            destination = "Balkans";
            switch (season) {
                case "summer":
                    accommodation = "Camp";
                    money = budget * 40 * 0.01;
                    break;
                case "winter":
                    accommodation = "Hotel";
                    money = budget * 80 * 0.01;
                    break;
            }
        } else {
            destination = "Europe";
            accommodation = "Hotel";
            money = budget * 90 * 0.01;
        }
        System.out.printf("Somewhere in %s %n", destination);
        System.out.printf("%s - %.2f", accommodation, money);
    }
}


