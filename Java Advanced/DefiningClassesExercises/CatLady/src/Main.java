import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<Cat> cats = new HashSet<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[1];
            double specification = Double.parseDouble(tokens[2]);
            Cat cat;
            switch (tokens[0]) {
                case "Siamese":
                    cat = new Siamese(name, specification);
                    break;
                case "Cymric":
                    cat = new Cymric(name, specification);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, specification);
                    break;
                default:
                    cat = null;
            }
            cats.add(cat);
            input = scanner.nextLine();
        }
        String catToPrint = scanner.nextLine();
        cats.stream()
                .filter(c->c.getName().equals(catToPrint))
                .forEach(System.out::println);
    }
}
