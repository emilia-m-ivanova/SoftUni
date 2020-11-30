import java.util.Scanner;

public class Everest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Той започвa изкачването си от ден първи от базов лагер, който е на 5 364 метра, а самият връх е на 8 848м.
        String input = scanner.nextLine();
        int days = 1;
        int metersSoFar = 5364;
        while (!input.equals("END")) {
            int meters = Integer.parseInt(scanner.nextLine());
            if (input.equals("Yes")) {
                days++;
            }
            if (days > 5) {
                break;
            }
            metersSoFar += meters;
            if (metersSoFar >= 8848) {
                break;
            }
            input = scanner.nextLine();
        }
        if (metersSoFar >= 8848) {
            System.out.printf("Goal reached for %d days!", days);
        } else {
            System.out.printf("Failed!%n%d", metersSoFar);
        }
    }
}
