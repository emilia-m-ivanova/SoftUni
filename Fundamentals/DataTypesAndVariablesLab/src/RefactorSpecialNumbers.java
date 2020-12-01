import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            boolean isSpecial;
            int sum = 0;
            int currentDigit = i;
            while (currentDigit > 0) {
                sum += currentDigit % 10;
                currentDigit = currentDigit / 10;
            }
            isSpecial = (sum == 5) || (sum == 7) || (sum == 11);
            System.out.printf("%d -> %b%n", i, isSpecial);
        }
    }
}
