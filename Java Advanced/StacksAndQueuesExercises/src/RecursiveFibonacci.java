import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(getFibonacci(n));
    }
    public static List<Long> fibArray = new ArrayList<>(){{add(1L);add(1L);}};

    public static long getFibonacci(int n) {
        long result;
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if(fibArray.size()>n){
            return fibArray.get(n);
        }
        result = getFibonacci(n-1)+getFibonacci(n-2);
        fibArray.add(result);
        return result;
    }
}
