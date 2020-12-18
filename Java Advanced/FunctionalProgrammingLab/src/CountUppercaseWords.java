import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<String> filterUpperCase = s-> Character.isUpperCase(s.charAt(0));
        List<String> list = Arrays.stream(scanner.nextLine().split(" "))
                .filter(e->filterUpperCase.test(e))
                .collect(Collectors.toList());
        System.out.println(list.size());
        list.forEach(System.out::println);
    }
}
