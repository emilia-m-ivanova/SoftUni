import java.util.Scanner;

public class DivideWithoutRemainder1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        for (int i = 1; i <= count; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if (num % 2 == 0) {
                num2++;
            }
            if (num % 3 == 0) {
                num3++;
            }
            if (num % 4 == 0) {
                num4++;
            }
        }
        double p1 = num2 * 100 / (count * 1.0);
        double p2 = num3 * 100 / (count * 1.0);
        double p3 = num4 * 100 / (count * 1.0);
        System.out.printf("%.2f%%%n", p1);
        System.out.printf("%.2f%%%n", p2);
        System.out.printf("%.2f%%%n", p3);
    }
}
