import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

        System.out.println(new DecimalFormat("0.####").format(mathPower(number,power)));
    }

    private static double mathPower(double number, int power) {
        double result = 1;
        for (int i = 0; i < power; i++) {
            result*=number;
        }
        return result;
    }
}
