import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Map<String, List<String>>> continents = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];
            continents.putIfAbsent(continent,new LinkedHashMap<>());
            continents.get(continent).putIfAbsent(country,new ArrayList<>());
            continents.get(continent).get(country).add(city);
        }
        continents.forEach((k,v)->{
            System.out.println(k+":");
            v.forEach((country,cities)-> System.out.println(country + " -> "+String.join(", ",cities)));
        });
    }
}
