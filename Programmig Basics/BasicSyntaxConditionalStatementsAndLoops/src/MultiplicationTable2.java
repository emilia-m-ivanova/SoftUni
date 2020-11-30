import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        do{
            System.out.printf("%d X %d = %d%n",n,m,n*m);
            m++;
        }while (m<=10);
    }
}
