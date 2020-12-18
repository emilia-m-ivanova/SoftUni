import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;
public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BiFunction<Integer, Integer, Integer> sortEvenOdd = (a,b)->{
            if(a%2==0 && b%2 != 0){
                return -1;
            }else if(b%2==0 && a%2 !=0){
                return 1;
            }
            return 0;
        };
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(Integer::compareTo)
                .sorted(sortEvenOdd::apply)
                .forEach(e-> System.out.print(e + " "));
    }
}
