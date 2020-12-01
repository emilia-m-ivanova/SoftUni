import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lines; i++) {
            long num1 = scanner.nextLong();
            long num2 = scanner.nextLong();
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < String.valueOf(num1).length(); j++) {
                if (String.valueOf(num1).charAt(j) != 45) {
                    sum1 += ((String.valueOf(num1).charAt(j)) - 48);
                }
            }
            for (int k = 0; k < String.valueOf(num2).length(); k++) {
                if (String.valueOf(num2).charAt(k) != 45) {
                    sum2 += (String.valueOf(num2).charAt(k)) - 48;
                }
            }
            if (num1 > num2) {
                System.out.println(sum1);
            } else {
                System.out.println(sum2);
            }
        }
    }
}
