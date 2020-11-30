import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double N1 = Double.parseDouble(scanner.nextLine());
        double N2 = Double.parseDouble(scanner.nextLine());
        String operation = scanner.nextLine();
        double result = 0;
        switch (operation) {
            case "+":
                result = N1 + N2;
                break;
            case "-":
                result = N1 - N2;
                break;
            case "*":
                result = N1 * N2;
                break;
            case "/":
                result = N1 / N2;
                break;
            case "%":
                result = N1 % N2;
                break;
        }
        if ((N2 == 0) && (operation.equals("/")) || (operation.equals("%")) && (N2==0)){
            System.out.printf("Cannot divide %.0f by zero", N1);
        } else {
            String evenOrOdd = "";
            if (result % 2 == 0) {
                evenOrOdd = "even";
            } else {
                evenOrOdd = "odd";
            }
            if (operation.equals("+") || (operation.equals("-")) || (operation.equals("*"))) {
                System.out.printf("%.0f %s %.0f = %.0f - %s", N1, operation, N2, result, evenOrOdd);
            } else if (operation.equals("/")) {
                System.out.printf("%.0f %s %.0f = %.2f", N1, operation, N2, result);
            } else {
                System.out.printf("%.0f %s %.0f = %.0f", N1, operation, N2, result);
            }
        }
    }
}
