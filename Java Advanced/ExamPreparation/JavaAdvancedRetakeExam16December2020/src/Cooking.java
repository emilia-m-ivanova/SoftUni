import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        //queue
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(liquids::offer);

        //stack
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        Map<String, Integer[]> foods = new TreeMap<>(Map.of(
                "Bread", new Integer[]{25, 0},
                "Cake", new Integer[]{50, 0},
                "Fruit Pie", new Integer[]{100, 0},
                "Pastry", new Integer[]{75, 0}));

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {

            int sum = liquids.poll() + ingredients.peek();
            Map.Entry<String, Integer[]> cooked = foods.entrySet()
                    .stream()
                    .filter(e -> e.getValue()[0] == sum)
                    .findFirst()
                    .orElse(null);
            if (cooked == null) {
                ingredients.push(ingredients.pop() + 3);
            } else {
                ingredients.pop();
                foods.get(cooked.getKey())[1] = foods.get(cooked.getKey())[1] + 1;
            }
        }

        System.out.println(foods.values().stream()
                .noneMatch(v -> v[1] == 0) ?
                "Wohoo! You succeeded in cooking all the food!" :
                "Ugh, what a pity! You didn't have enough materials to to cook everything.");
        System.out.println("Liquids left: " + (liquids.isEmpty() ?
                "none" :
                liquids.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "))));
        System.out.println("Ingredients left: " + (ingredients.isEmpty() ?
                "none" :
                ingredients.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "))));
        foods.forEach((k, v) -> System.out.println(k + ": " + v[1]));
    }
}
