import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            sum+=num;
        }
        System.out.println(sum);
    }
}
