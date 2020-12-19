import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        List<String> filters = new ArrayList<>();
        String command = scanner.nextLine();
        while (!command.equals("Print")) {
            String filter = command.substring(command.indexOf(';')+1);
            if (command.startsWith("Add")) {
                filters.add(filter);
            } else {
                filters.remove(filter);
            }
            command = scanner.nextLine();
        }
        filters.stream()
                .map(e -> getPredicate(e))
                .forEach(guests::removeIf);
        guests.forEach(g -> System.out.print(g + " "));
    }

    private static Predicate<String> getPredicate(String str) {
        String[] tokens = str.split(";");
        String condition = tokens[0];
        String parameter = tokens[1];
        Predicate<String> result = null;
        switch (condition) {
            case "Starts with":
                result = e -> e.startsWith(parameter);
                break;
            case "Ends with":
                result = e -> e.endsWith(parameter);
                break;
            case "Length":
                result = e -> e.length() == Integer.parseInt(parameter);
                break;
            case "Contains":
                result = e -> e.contains(parameter);
        }
        return result;
    }
}
