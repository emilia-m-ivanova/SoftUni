import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> chemicals = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            chemicals.addAll(Arrays.stream(scanner.nextLine().split("\\s+"))
                    .collect(Collectors.toSet()));
        }
        System.out.print(String.join(" ",chemicals));
    }
}
