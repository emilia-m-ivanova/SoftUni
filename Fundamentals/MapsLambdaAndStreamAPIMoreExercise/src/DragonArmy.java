import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, List<Integer>>> types = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String type = input[0];
            String dragon = input[1];
            int damage = 45;
            int health = 250;
            int armor = 10;
            if (!input[2].equals("null")) {
                damage = Integer.parseInt(input[2]);
            }
            if (!input[3].equals("null")) {
                health = Integer.parseInt(input[3]);
            }
            if (!input[4].equals("null")) {
                armor = Integer.parseInt(input[4]);
            }
            types.putIfAbsent(type, new TreeMap<>());
            types.get(type).put(dragon, Arrays.asList(damage, health, armor));
        }

        types.forEach((k, v) -> {
            double avDamage = v.values()
                    .stream()
                    .mapToInt(l -> l.get(0))
                    .average()
                    .getAsDouble();
            double avHealth = v.values()
                    .stream()
                    .mapToInt(l -> l.get(1))
                    .average()
                    .getAsDouble();
            double avArmor = v.values()
                    .stream()
                    .mapToInt(l -> l.get(2))
                    .average()
                    .getAsDouble();
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", k, avDamage, avHealth, avArmor);
            v.forEach((k2, v2) -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                    k2,v2.get(0),v2.get(1),v2.get(2)));
        });

    }
}
