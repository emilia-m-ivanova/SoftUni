import java.util.*;

public class PlantDiscovery {
    static class PlantDetails {
        int rarity;
        List<Integer> rating;

        public PlantDetails(int rarity, List<Integer> rating) {
            this.rarity = rarity;
            this.rating = rating;
        }

        public int getRarity() {
            return this.rarity;
        }

        public List<Integer> getRating() {
            return this.rating;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public void setRating(List<Integer> rating) {
            this.rating = rating;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, PlantDetails> plants = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("<->");
            String plant = input[0];
            int rarity = Integer.parseInt(input[1]);
            PlantDetails plantDetails = new PlantDetails(rarity, new ArrayList<>());
            plants.put(plant, plantDetails);
        }
        String input = scanner.nextLine();
        while (!input.equals("Exhibition")) {
            String[] command = input.split(":\\s+");
            switch (command[0]) {
                case "Rate":
                    if ((command[1].split("\\s+-\\s+")).length != 2) {
                        System.out.println("error");
                    } else {
                        String plant = command[1].split("\\s+-\\s+")[0];
                        int rating = Integer.parseInt(command[1].split("\\s+-\\s+")[1]);
                        if(plants.containsKey(plant)) {
                            plants.get(plant).getRating().add(rating);
                        }else{
                            System.out.println("error");
                        }
                    }
                    break;
                case "Update":
                    if ((command[1].split("\\s+-\\s+")).length != 2) {
                        System.out.println("error");
                    } else {
                        String plant = command[1].split("\\s+-\\s+")[0];
                        int newRarity = Integer.parseInt(command[1].split("\\s+-\\s+")[1]);
                        if(plants.containsKey(plant)) {
                            plants.get(plant).setRarity(newRarity);
                        }else{
                            System.out.println("error");
                        }
                    }
                    break;

                case "Reset":
                    if (command.length==1) {
                        System.out.println("error");
                    } else {
                        String plant = command[1];
                        if(plants.containsKey(plant)) {
                            plants.get(plant).setRating(new ArrayList<>());
                        }else{
                            System.out.println("error");
                        }
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plants.entrySet()
                .stream()
                .sorted((a, b) ->{
                            double first = 0;
                            double second = 0;
                            if (a.getValue().getRating().size() != 0) {
                                first = a.getValue().getRating().stream().mapToInt(Integer::intValue).average().getAsDouble();
                            }
                            if (b.getValue().getRating().size() != 0) {
                                second = b.getValue().getRating().stream().mapToInt(Integer::intValue).average().getAsDouble();
                            }
                            return Double.compare(second, first);
                        })
                .sorted((a, b) ->{
                            int first = a.getValue().getRarity();
                            int second = b.getValue().getRarity();
                            return Integer.compare(second, first);
                        })
                .forEach(p ->{
                            double rating = 0;
                            if (p.getValue().getRating().size() != 0) {
                                rating = p.getValue().getRating().stream().mapToInt(Integer::intValue).average().getAsDouble();
                            }
                            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                                    p.getKey(), p.getValue().getRarity(), rating);
                        });
    }
}
