import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n1 = Double.parseDouble(scanner.nextLine());
        double n2 = Double.parseDouble(scanner.nextLine());
        double epsilon = 0.000001;
        if(Math.abs((n1-n2))<epsilon){
            System.out.println("True");
        } else{
            System.out.println("False");
        }
    }
}
