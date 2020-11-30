import java.util.Scanner;

public class LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < count; i++) {
            int num1 = Integer.parseInt(scanner.nextLine());
            sum1+=num1;
        }
        for (int i = 0; i < count; i++) {
            int num2 = Integer.parseInt(scanner.nextLine());
            sum2+=num2;
        }
        if(sum1==sum2){
            System.out.printf("Yes, sum = %d",sum1);
        }else{
            int diff = Math.abs(sum1-sum2);
            System.out.printf("No, diff = %d",diff);
        }
    }
}
