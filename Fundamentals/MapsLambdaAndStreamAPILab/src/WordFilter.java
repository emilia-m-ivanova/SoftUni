import java.util.Arrays;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split(" "))
        .filter(e -> e.length()%2==0)
                .forEach(e -> System.out.println(e));
    }
}
