import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            if (isTopNumber(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isTopNumber(int n) {
        return sumOfDigitsIsDivisibleBy8(n) && holdsOddDigit(n);
    }

    private static boolean holdsOddDigit(int n) {
        while (n > 0) {
            if (n % 2 == 1) {
                return true;
            }
            n /= 10;
        }
        return false;
    }

    private static boolean sumOfDigitsIsDivisibleBy8(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum % 8 == 0;
    }
}
