import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double area = getArea(a, b);
        System.out.printf("%.0f", area);
    }

    private static double getArea(double width, double height) {
        return width * height;
    }
}
