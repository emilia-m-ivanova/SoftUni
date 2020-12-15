import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int n = size[0];
        int m = size[1];
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            firstSet.add(scanner.nextInt());
        }
        for (int i = 0; i < m; i++) {
            secondSet.add(scanner.nextInt());
        }
        firstSet.retainAll(secondSet);
        firstSet.forEach(e-> System.out.print(e+" "));
    }
}
