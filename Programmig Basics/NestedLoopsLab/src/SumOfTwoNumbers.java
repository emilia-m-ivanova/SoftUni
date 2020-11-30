import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int magicNum = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        for (int i = num1; i <=num2 ; i++) {
            for (int j = num1; j <=num2 ; j++) {
                counter++;
                if(i+j==magicNum){
                    System.out.printf("Combination N:%d (%d + %d = %d)",counter,i,j,magicNum);
                    return;
                }
            }
            
        }
        System.out.printf("%d combinations - neither equals %d",counter,magicNum);
    }
}
