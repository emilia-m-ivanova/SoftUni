import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 1; i <= count; i++) {
            if (i % 2 == 1) {
                int num1 = Integer.parseInt(scanner.nextLine());
                sum1 += num1;
            }
            if (i % 2 == 0) {
                int num2 = Integer.parseInt(scanner.nextLine());
                sum2 += num2;
            }
        }
        if (sum1==sum2){
            System.out.println("Yes");
            System.out.printf("Sum = %d",sum1);
        }else{
            int diff = Math.abs(sum1-sum2);
            System.out.println("No");
            System.out.printf("Diff = %d",diff);
        }
    }
}
