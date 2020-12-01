import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new HashMap<>();
        Map<String, Integer> otherMaterials = new HashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        while (keyMaterials.get("shards") < 250
                && keyMaterials.get("fragments") < 250
                && keyMaterials.get("motes") < 250) {
            int quantity = scanner.nextInt();
            String material = scanner.next().toLowerCase();
            if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                keyMaterials.put(material, keyMaterials.get(material) + quantity);
            } else {
                if (!otherMaterials.containsKey(material)) {
                    otherMaterials.put(material, 0);
                }
                otherMaterials.put(material, otherMaterials.get(material) + quantity);
            }
        }
        if (keyMaterials.get("shards") >= 250) {
            System.out.println("Shadowmourne obtained!");
            keyMaterials.put("shards", keyMaterials.get("shards") - 250);
        } else if (keyMaterials.get("fragments") >= 250) {
            System.out.println("Valanyr obtained!");
            keyMaterials.put("fragments", keyMaterials.get("fragments") - 250);
        } else {
            System.out.println("Dragonwrath obtained!");
            keyMaterials.put("motes", keyMaterials.get("motes") - 250);
        }
        keyMaterials.entrySet()
                .stream()
                .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        otherMaterials.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
