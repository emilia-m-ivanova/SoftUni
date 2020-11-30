import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        double oddSum = 0;
        double oddMin = Integer.MAX_VALUE;
        double oddMax = Integer.MIN_VALUE;
        double evenSum = 0;
        double evenMin = Integer.MAX_VALUE;
        double evenMax = Integer.MIN_VALUE;
        for (int i = 1; i <= count; i++) {
            double num = Double.parseDouble(scanner.nextLine());
            if (i % 2 == 0) {
                evenSum += num;
                if (evenMin > num) {
                    evenMin = num;
                }
                if (evenMax < num) {
                    evenMax = num;
                }
            } else {
                oddSum += num;
                if (oddMin > num) {
                    oddMin = num;
                }
                if (oddMax < num) {
                    oddMax = num;
                }

            }
        }
        System.out.printf("OddSum=%.2f,%n", oddSum);
        if (oddMin == Integer.MAX_VALUE) {
            System.out.println("OddMin=No,");
        } else {
            System.out.printf("OddMin=%.2f,%n", oddMin);
        }
        if (oddMax == Integer.MIN_VALUE) {
            System.out.println("OddMax=No,");
        } else {
            System.out.printf("OddMax=%.2f,%n", oddMax);
        }
        System.out.printf("EvenSum=%.2f,%n", evenSum);
        if (evenMin == Integer.MAX_VALUE) {
            System.out.println("EvenMin=No,");
        } else {
            System.out.printf("EvenMin=%.2f,%n", evenMin);
        }
        if (evenMax == Integer.MIN_VALUE) {
            System.out.println("EvenMax=No");
        } else {
            System.out.printf("EvenMax=%.2f%n", evenMax);
        }
    }
}
