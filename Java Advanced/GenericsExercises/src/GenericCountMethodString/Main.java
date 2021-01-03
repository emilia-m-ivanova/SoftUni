package GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box<String>> boxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boxList.add(new Box<>(scanner.nextLine()));
        }
        Box<String> compareElement = new Box<>(scanner.nextLine());
        System.out.println(getCountOfGreater(boxList,compareElement));
    }

    private static <T extends Comparable<T>> long getCountOfGreater(List<Box<T>> list, Box<T> compareElement) {
        return list.stream()
                .filter(e -> e.compareTo(compareElement) > 0)
                .count();

    }
}
