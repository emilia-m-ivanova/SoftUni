import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(", ");
        Function<String, Integer> parse = Integer::parseInt;
        int sum = 0;

        for (String s : arr) {
            sum+=parse.apply(s);
        }

        System.out.println("Count = " + arr.length);
        System.out.println("Sum = " + sum);
    }
}
