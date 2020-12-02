import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        BigInteger f = new BigInteger("1");
        for (int i = 1; i <=n ; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        System.out.println(f);
    }
}
