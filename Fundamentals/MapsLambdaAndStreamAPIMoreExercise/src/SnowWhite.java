import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SnowWhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> hats = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Once upon a time")) {
            String[] tokens = input.split(" <:> ");
            String name = tokens[0];
            String hat = tokens[1];
            int physics = Integer.parseInt(tokens[2]);
            hats.putIfAbsent(hat, new LinkedHashMap<>());
            hats.get(hat).putIfAbsent(name, physics);
            if (hats.get(hat).get(name) < physics) {
                hats.get(hat).put(name, physics);
            }
            input = scanner.nextLine();
        }
        Map<String, Integer> outputMap = new LinkedHashMap<>();
        hats.entrySet()
                .stream()
                .sorted((d1, d2) -> {
                    int first = d1.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    int second = d2.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    return Integer.compare(second, first);
                })
                .forEach(e -> e.getValue().forEach((key, value) -> {
                    String newKey = String.format("(%s) %s", e.getKey(), key);
                    outputMap.put(newKey, value);
                }));

                outputMap.entrySet()
                        .stream()
                        .sorted((v1,v2)->Integer.compare(v2.getValue(),v1.getValue()))
                        .forEach(v-> System.out.printf("%s <-> %d%n",v.getKey(),v.getValue()));

    }
}
