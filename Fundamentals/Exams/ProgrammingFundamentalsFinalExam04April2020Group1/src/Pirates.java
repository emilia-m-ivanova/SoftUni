import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<Integer>> cities = new TreeMap<>();

        //first part
        while (!input.equals("Sail")) {
            String[] town = input.split("\\|\\|");
            String name = town[0];
            int population = Integer.parseInt(town[1]);
            int gold = Integer.parseInt(town[2]);
            cities.putIfAbsent(name, new ArrayList<>() {{
                add(0);
                add(0);
            }});
            cities.get(name).set(0, population + cities.get(name).get(0));
            cities.get(name).set(1, gold + cities.get(name).get(1));
            input = scanner.nextLine();
        }

        //second part
        input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] events = input.split("=>");
            String town = events[1];
            int people;
            int gold;
            switch (events[0]) {
                case "Plunder":
                    people = Integer.parseInt(events[2]);
                    gold = Integer.parseInt(events[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
                    cities.get(town).set(0, cities.get(town).get(0) - people);
                    cities.get(town).set(1, cities.get(town).get(1) - gold);
                    if (cities.get(town).get(0) == 0 ||
                            cities.get(town).get(1) == 0){
                        System.out.println(town+" has been wiped off the map!");
                        cities.remove(town);
                    }
                        break;
                case "Prosper":
                    gold = Integer.parseInt(events[2]);
                    if(gold<0){
                        System.out.println("Gold added cannot be a negative number!");
                    }else{
                        cities.get(town).set(1,gold+cities.get(town).get(1));
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                                gold,town,cities.get(town).get(1));
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        //print
        if(cities.isEmpty()){
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }else{
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",cities.size());
            cities.entrySet()
                    .stream()
                    .sorted((a,b)->b.getValue().get(1).compareTo(a.getValue().get(1)))
                    .forEach(c-> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                            c.getKey(),c.getValue().get(0),c.getValue().get(1)));
        }
    }
}
