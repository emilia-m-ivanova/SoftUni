import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] bounds = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String command = scanner.nextLine();
        IntPredicate condition;
        if (command.equals("odd")) {
            condition = e -> e % 2 != 0;
        } else {
            condition = e -> e % 2 == 0;
        }
        IntStream.range(bounds[0], bounds[1] + 1)
                .filter(condition)
                .forEach(e -> System.out.print(e + " "));
    }
}
