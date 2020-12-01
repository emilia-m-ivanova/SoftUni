import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextLine().charAt(0);
        if(65<=input&&input<=90){
            System.out.println("upper-case");
        }else{
            System.out.println("lower-case");
        }
    }
}
