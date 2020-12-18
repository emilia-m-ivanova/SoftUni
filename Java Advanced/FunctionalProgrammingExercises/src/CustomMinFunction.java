import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<int[],Integer> findSmallestNum = e -> {
            int smallestNum = Integer.MAX_VALUE;
            for (int current : e) {
                if(current<smallestNum){
                    smallestNum = current;
                }
            }
            return smallestNum;
        };
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(findSmallestNum.apply(arr));
    }
}
