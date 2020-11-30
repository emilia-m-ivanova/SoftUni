import java.util.Scanner;

public class SumOfOddNumbers1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i <2*n ; i++) {
            if (i%2==1){
                System.out.println(i);
                sum+=i;
            }
        }
        System.out.printf("Sum: %d",sum);
    }
}
