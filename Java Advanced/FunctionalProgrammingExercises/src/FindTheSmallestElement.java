import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<List<Integer>,Integer> findSmallestNum = e -> {
            int smallestNum = Integer.MAX_VALUE;
            for (int current : e) {
                if(current < smallestNum){
                    smallestNum = current;
                }
            }
            return smallestNum;
        };
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Integer min = findSmallestNum.apply(numbers);
        System.out.println(numbers.lastIndexOf(min));
    }
}
