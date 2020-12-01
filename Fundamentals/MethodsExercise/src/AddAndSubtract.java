import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        System.out.println(result(num1, num2, num3));
    }

    private static int result(int num1, int num2, int num3) {

        return sum(num1, num2) - num3;
    }

    private static int sum(int num1, int num2) {

        return num1 + num2;
    }
}
