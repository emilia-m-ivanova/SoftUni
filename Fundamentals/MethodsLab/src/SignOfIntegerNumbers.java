import java.util.Scanner;

public class SignOfIntegerNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printSignOfNumbers(Integer.parseInt(scanner.nextLine()));
    }

    private static void printSignOfNumbers(int number) {
        if(number>0){
            System.out.printf("The number %d is positive.",number);
        }else if(number<0){
            System.out.printf("The number %d is negative.",number);
        }else{
            System.out.println("The number 0 is zero.");
        }
    }
}
