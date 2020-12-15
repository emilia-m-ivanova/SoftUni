import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Map<String,Long>> countries = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while(!input.equals("report")){
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long count = Long.parseLong(tokens[2]);
            countries.putIfAbsent(country,new LinkedHashMap<>());
            countries.get(country).putIfAbsent(city,count);
            input = scanner.nextLine();
        }
        countries.entrySet().stream()
                .sorted((a,b)->{
                    long populationA = a.getValue().values().stream()
                            .mapToLong(Long::longValue).sum();
                    long populationB = b.getValue().values().stream()
                            .mapToLong(Long::longValue).sum();
                    return Long.compare(populationB,populationA);
                })
                .forEach(e-> {
                    long population = e.getValue().values().stream()
                            .mapToLong(Long::longValue).sum();
                    System.out.println(e.getKey() + " (total population: " + population + ")");
                    e.getValue().entrySet().stream()
                            .sorted((a,b)->b.getValue().compareTo(a.getValue()))
                            .forEach(city-> System.out.printf("=>%s: %d%n",city.getKey(),city.getValue()));
                });
    }
}