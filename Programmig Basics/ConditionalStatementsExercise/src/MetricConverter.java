import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = Double.parseDouble(scanner.nextLine());
        String initial = scanner.nextLine();
        String expected = scanner.nextLine();
        double result = 0;
        if (initial.equals("m")) {
            if (expected.equals("m")) {
                result = num;
            }
            if (expected.equals("cm")) {
                result = num * 100;
            }
            if (expected.equals("mm")) {
                result = num * 1000;
            }
        }
        if (initial.equals("cm")) {
            if (expected.equals("m")) {
                result = num * 0.01;
            }
            if (expected.equals("cm")) {
                result = num;
            }
            if (expected.equals("mm")) {
                result = num * 10;
            }
        }
        if (initial.equals("mm")) {
            if (expected.equals("m")) {
                result = num * 0.001;
            }
            if (expected.equals("cm")) {
                result = num * 0.1;
            }
            if (expected.equals("mm")) {
                result = num;
            }
        }
        System.out.printf("%.3f", result);
    }
}
