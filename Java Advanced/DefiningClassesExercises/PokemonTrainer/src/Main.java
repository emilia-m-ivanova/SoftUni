import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Trainer> trainers = new LinkedHashSet<>();
        readTrainers(scanner, trainers);
        performCommands(scanner, trainers);
        trainers.stream()
                .sorted((a,b)->Integer.compare(b.getBadges(),a.getBadges()))
                .forEach(System.out::println);
    }

    private static void readTrainers(Scanner scanner, Set<Trainer> trainers) {
        String input = scanner.nextLine();
        while (!input.equals("Tournament")) {
            String[] tokens = input.split("\\s+");
            String trainer = tokens[0];
            String pokemon = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);
            boolean trainerAdded = trainers.stream()
                    .anyMatch(t -> t.getName().equals(trainer));
            if (!trainerAdded) {
                trainers.add(new Trainer(trainer));
            }
            Trainer currentTrainer = trainers.stream()
                    .filter(t -> t.getName().equals(trainer))
                    .findFirst()
                    .get();
            currentTrainer.getPokemons().add(new Pokemon(pokemon, element, health));
            input = scanner.nextLine();
        }
    }

    private static void performCommands(Scanner scanner, Set<Trainer> trainers) {
        String element = scanner.nextLine();
        while (!element.equals("End")) {
            String finalElement = element;
            Predicate<Pokemon> matchesElement = p -> p.getElement().equals(finalElement);
            trainers.stream()
                    .filter(t -> t.getPokemons()
                            .stream()
                            .anyMatch(matchesElement))
                    .forEach(Trainer::increaseBadges);
            trainers.stream()
                    .filter(t -> t.getPokemons()
                            .stream()
                            .noneMatch(matchesElement))
                    .forEach(t -> t.getPokemons()
                            .forEach(Pokemon::decreaseHealth));
            trainers
                    .forEach(t->t.getPokemons()
                            .removeIf(p->p.getHealth()<=0));
            element = scanner.nextLine();
        }
    }
}
