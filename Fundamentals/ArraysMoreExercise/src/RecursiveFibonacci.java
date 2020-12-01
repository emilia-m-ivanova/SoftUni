import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if (1 <= n && n <= 50) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                if (i > 1) {
                    array[i] = array[i - 1] + array[i - 2];
                } else {
                    array[i] = 1;
                }
            }
            System.out.println(array[n - 1]);
        }else{
            System.out.println(0);
        }
    }
}
