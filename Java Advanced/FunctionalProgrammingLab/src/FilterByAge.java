import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(", ");
            String name = line[0];
            int age = Integer.parseInt(line[1]);
            people.put(name, age);
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();
        Predicate<Integer> filter = getPredicate(condition, age);
        Consumer<Map.Entry<String,Integer>> printer = getPrinter(format);

        people.entrySet()
                .stream()
                .filter(e -> filter.test(e.getValue()))
                .forEach(e-> printer.accept(e));
    }

    private static Consumer<Map.Entry<String, Integer>> getPrinter(String format) {
        Consumer<Map.Entry<String,Integer>> result;
        switch (format){
            case "name":
                result = e-> System.out.println(e.getKey());
                break;
            case "age":
                result = e -> System.out.println(e.getValue());
                break;
            default: result = e -> System.out.printf("%s - %d%n",e.getKey(),e.getValue());
        }
        return result;
    }

    private static Predicate<Integer> getPredicate(String condition, int age) {
        Predicate<Integer> result = null;
        switch (condition) {
            case "older":
                result = e -> e >= age;
                break;
            case "younger":
                result = e -> e <= age;
                break;
        }
        return result;
    }
}
