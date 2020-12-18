import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(e->e%2==0)
                .collect(Collectors.toList());
        printNumbers(numbers);
        numbers.sort(Integer::compareTo);
        printNumbers(numbers);
    }

    private static void printNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if(i!= numbers.size()-1){
                System.out.print(", ");
            }else{
                System.out.println();
            }
        }
    }
}
