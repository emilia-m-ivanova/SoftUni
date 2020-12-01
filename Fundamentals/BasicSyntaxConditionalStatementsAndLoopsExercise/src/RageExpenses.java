import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());
        int headsetBroken = lostGamesCount/2;
        int mouseBroken = lostGamesCount/3;
        int keyboardBroken = 0;
            keyboardBroken=mouseBroken/2;
        int displayBroken = keyboardBroken/2;
        double expenses = headsetBroken*headsetPrice+mouseBroken*mousePrice+keyboardBroken*keyboardPrice+displayBroken*displayPrice;

        System.out.printf("Rage expenses: %.2f lv.",expenses);
    }
}
