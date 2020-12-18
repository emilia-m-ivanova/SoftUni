import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> factors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Predicate<Integer> divisibleByNumbers = e -> {
            for (Integer factor : factors) {
                if(e%factor!=0){
                    return false;
                }
            }
            return true;
        };
        IntStream.range(1,n+1)
        .filter(divisibleByNumbers::test)
        .forEach(e -> System.out.print(e + " "));
    }
}
