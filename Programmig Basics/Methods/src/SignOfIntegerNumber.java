import java.util.Scanner;

public class SignOfIntegerNumber {
    static void printSign (int n){
    if (n>0){
        System.out.printf("The number %d is positive.",n);
    } else if (n==0){
        System.out.printf("The number %d is zero.",n);
    }else{
        System.out.printf("The number %d is negative.",n);
    }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printSign(n);
    }
}
