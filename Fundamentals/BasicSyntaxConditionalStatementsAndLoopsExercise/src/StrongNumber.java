import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int length = number.length();
        int sum = 0;
        for (int i = 0; i <length ; i++) {
            int multiply = 1;
            int digit = Integer.parseInt(String.valueOf(number.charAt(i)));
            for (int j = 1; j <=digit ; j++) {
                multiply=multiply*j;
            }
            sum+=multiply;
        }
        if (sum==Integer.parseInt(number)){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
