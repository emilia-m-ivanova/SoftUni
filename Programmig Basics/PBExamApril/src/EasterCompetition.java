import java.util.Scanner;

public class EasterCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int briocheNum = Integer.parseInt(scanner.nextLine());
        int sumMax = Integer.MIN_VALUE;
        String winner = "";
        for (int i = 1; i <= briocheNum; i++) {
            String name = scanner.nextLine();
            String input = scanner.nextLine();
            int sum = 0;
            while (!input.equals("Stop")) {
                int score = Integer.parseInt(input);
                sum += score;
                input = scanner.nextLine();
            }
            System.out.printf("%s has %d points.%n", name, sum);
            if (sum > sumMax) {
                sumMax=sum;
                System.out.printf("%s is the new number 1!%n", name);
                winner = name;
            }
        }
        System.out.printf("%s won competition with %d points!", winner,sumMax);
    }

}

