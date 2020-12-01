import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        System.out.printf("%.2f", resultDivided(n1, n2));
    }

    private static double resultDivided(int n1, int n2) {
        return (double) getFactorial(n1) / getFactorial(n2);
    }

    private static long getFactorial(int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
