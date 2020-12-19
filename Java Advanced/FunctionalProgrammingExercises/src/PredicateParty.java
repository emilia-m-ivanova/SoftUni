import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            String[] tokens = input.split("\\s+");
            Predicate<String> condition = getPredicate(tokens[1], tokens[2]);
            if (tokens[0].equals("Double")) {
                List<String> toAdd = guests.stream()
                        .filter(condition)
                        .collect(Collectors.toList());
                guests.addAll(toAdd);
            } else {
                guests.removeIf(condition);
            }
            input = scanner.nextLine();
        }
        Collections.sort(guests);
        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(String.join(", ", guests) + " are going to the party!");
        }
    }

    private static Predicate<String> getPredicate(String condition, String parameter) {
        Predicate<String> result = null;
        switch (condition) {
            case "StartsWith":
                result = e -> e.startsWith(parameter);
                break;
            case "EndsWith":
                result = e -> e.endsWith(parameter);
                break;
            case "Length":
                result = e -> e.length() == Integer.parseInt(parameter);
                break;
        }
        return result;
    }
}

