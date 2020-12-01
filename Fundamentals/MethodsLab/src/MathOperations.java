import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n1 = Double.parseDouble(scanner.nextLine());
        String operator = scanner.nextLine();
        double n2 = Double.parseDouble(scanner.nextLine());
        System.out.println(new DecimalFormat("0.##").format(getCalculatedValue(n1, operator, n2)));

    }

    private static double getCalculatedValue(double n1, String operator, double n2) {
        double result = 0;
        switch (operator) {
            case "/":
                result = n1 / n2;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
        }
        return result;
    }
}
